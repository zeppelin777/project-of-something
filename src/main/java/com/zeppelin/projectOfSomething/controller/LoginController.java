package com.zeppelin.projectOfSomething.controller;

import com.zeppelin.projectOfSomething.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class LoginController {

  @GetMapping("/user")
  public String all(ModelMap model) {
    User user = new User(1, "test", "test@qq.com", "test", 0, new Date(), new Date());
    model.addAttribute("user", user);
    return "index";
  }
}
