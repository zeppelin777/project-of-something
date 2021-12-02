package com.zeppelin.projectOfSomething.controller;

import com.zeppelin.projectOfSomething.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class LoginController extends BaseController {

  @GetMapping("/verify")
  public String verify(User user, Map<String, Object> map) {
    User loginUser = new User();
    loginUser.setUserId(0);
    loginUser.setUserName("test");
    loginUser.setEmail("139420666@qq.com");
    loginUser.setPassword("test");
    session.setAttribute("loginUser", loginUser);
    return "index";
    //if (loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
    //
    //  return "index";
    //}
    //String errorMsg = (loginUser == null ? "该邮箱尚未注册" : "密码错误");
    //map.put("errorMsg", errorMsg);
    //return "index";
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

  @GetMapping("/register")
  public String register(User user, Map<String, Object> map) {
    user.setUserName(user.getUserName().trim());
    user.setRegisterTime(new Date());
    user.setRole(1);
    if (!userService.insert(user)) {
      map.put("errorMsg", "服务器发生错误，注册失败");
      return "index";
    }
    session.setAttribute("loginUser", user);
    return "index";
  }
}
