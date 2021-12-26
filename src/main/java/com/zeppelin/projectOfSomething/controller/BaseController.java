package com.zeppelin.projectOfSomething.controller;

import com.zeppelin.projectOfSomething.pojo.User;
import com.zeppelin.projectOfSomething.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The type Base controller.
 *
 * @author eddie
 */
public class BaseController {

  /**
   * The User service.
   */
  @Autowired
  protected UserService userService;

  /**
   * The Request.
   */
  protected HttpServletRequest request;
  /**
   * The Response.
   */
  protected HttpServletResponse response;
  /**
   * The Session.
   */
  protected HttpSession session;
  /**
   * The Login user.
   */
  protected User loginUser;

  /**
   * Sets req and res.
   *
   * @param request  the request
   * @param response the response
   */
  @ModelAttribute
  public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
    this.session = request.getSession(true);
    loginUser = (User) session.getAttribute("loginUser");
  }
}
