package com.zeppelin.projectOfSomething.controller;

import com.zeppelin.projectOfSomething.pojo.User;
import com.zeppelin.projectOfSomething.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {

  @Autowired protected UserService userService;

  protected HttpServletRequest request;
  protected HttpServletResponse response;
  protected HttpSession session;
  protected User loginUser;

  @ModelAttribute
  public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
    this.session = request.getSession(true);
    loginUser = (User) session.getAttribute("loginUser");
  }
}
