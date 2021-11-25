package com.zeppelin.projectOfSomething.controller;

import com.zeppelin.projectOfSomething.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class LoginController extends BaseController {

  @GetMapping("/login")
  public String login(User user, Map<String, Object> map) {
    User loginUser = userService.getUserByEmail(user.getEmail());
    if (loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
      session.setAttribute("loginUser", loginUser);
      return "index";
    }
    String errorMsg = (loginUser == null ? "该邮箱尚未注册" : "密码错误");
    map.put("errorMsg", errorMsg);
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
