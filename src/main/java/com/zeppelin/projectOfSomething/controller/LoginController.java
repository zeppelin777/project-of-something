package com.zeppelin.projectOfSomething.controller;

import com.zeppelin.projectOfSomething.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Objects;

/**
 * The type Login controller.
 *
 * @author eddie
 */
@Controller
public class LoginController extends BaseController {

  /**
   * Verify string.
   *
   * @param user the user
   * @param map  the map
   * @return the string
   */
  @PostMapping("/verify")
  public String verify(User user, Map<String, Object> map) {
    if (loginUser != null) {
      return "redirect:/";
    }
    User checkUser = userService.checkUserByEmailAndPassword(user.getEmail().trim(), user.getPassword().trim());
    if (checkUser != null) {
      session.setAttribute("loginUser", checkUser);
      return "redirect:/";
    }
    String errorMsg = ("登录失败");
    map.put("errorMsg", errorMsg);
    return "login";
  }

  /**
   * Login string.
   *
   * @return the string
   */
  @GetMapping("/login")
  public String login() {
    return "login";
  }

  /**
   * Logout string.
   *
   * @return the string
   */
  @GetMapping("/logout")
  public String logout() {
    session.removeAttribute("loginUser");
    return "redirect:/";
  }

  /**
   * Register string.
   *
   * @param user the user
   * @param map  the map
   * @return the string
   */
  @PostMapping("/register")
  public String register(@RequestParam(required = false) String confirmPassword, User user, Map<String, Object> map) {
    if (!Objects.equals(confirmPassword, user.getPassword())) {
      map.put("errorMsg", "确认密码不匹配");
      map.put("login", false);
      return "login";
    }
    if (userService.existsUserByEmail(user.getEmail().trim())) {
      map.put("errorMsg", "邮箱重复");
      map.put("login", false);
      return "login";
    }
    User save = userService.save(user);
    if (save == null) {
      map.put("errorMsg", "服务器发生错误，注册失败");
      map.put("login", false);
      return "login";
    }
    session.setAttribute("loginUser", save);
    return "redirect:/";
  }
}
