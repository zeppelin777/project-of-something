package com.zeppelin.projectOfSomething.service;

import com.zeppelin.projectOfSomething.pojo.User;

public interface UserService {
  User getUserByEmail(String email);

  boolean insert(User user);
}
