package com.zeppelin.projectOfSomething.service;

import com.zeppelin.projectOfSomething.pojo.User;

/**
 * The interface User service.
 *
 * @author eddie
 */
public interface UserService {

  /**
   * Gets user by email.
   *
   * @param email the email
   * @return the user by email
   */
  User getUserByEmail(String email);

  /**
   * Exists user by email boolean.
   *
   * @param email the email
   * @return the boolean
   */
  Boolean existsUserByEmail(String email);

  /**
   * check user by email and password.
   *
   * @param email    the email
   * @param password the password
   * @return the user by email and password
   */
  User checkUserByEmailAndPassword(String email, String password);

  /**
   * Save user.
   *
   * @param user the user
   * @return the user
   */
  User save(User user);
}
