package com.zeppelin.projectOfSomething.controller;

import com.zeppelin.projectOfSomething.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Controller
public class LoginController extends BaseController {

  @PostMapping("/verify")
  public String verify(User user, Map<String, Object> map) {
    if (loginUser != null) {
      return "index";
    }
    User checkUser = userService.getUserByEmail(user.getEmail());
    if (checkUser != null && Objects.equals(checkUser.getPassword(), user.getPassword())) {
      session.setAttribute("loginUser", checkUser);
      return "index";
    }
    String errorMsg = (checkUser == null ? "该邮箱尚未注册" : "密码错误");
    map.put("errorMsg", errorMsg);
    return "login";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/logout")
  public String logout() {
    session.removeAttribute("loginUser");
    return "index";
  }

  @PostMapping("/register")
  public String register(User user, Map<String, Object> map) {
    String confirmPassword = request.getParameter("confirmPassword");
    if (Objects.equals(confirmPassword, user.getPassword())) {
      if (userService.save(user) == null) {
        map.put("errorMsg", "密码不匹配");
        return "login";
      }
    }
    user.setUsername(user.getUsername().trim());
    user.setEmail(user.getEmail().trim());
    user.setPassword(user.getPassword().trim());
    user.setCreatedDate(new Date());
    user.setRole((byte) 1);
    try {
      if (userService.existsByEmail(user.getEmail())) {
        map.put("errorMsg", "邮箱重复");
        return "login";
      }
      if (userService.save(user) == null) {
        map.put("errorMsg", "服务器发生错误，注册失败");
        return "login";
      }
    } catch (Exception e) {
      map.put("errorMsg", "服务器发生错误，注册失败");
      return "login";
    }
    session.setAttribute("loginUser", user);
    return "index";
  }
}
