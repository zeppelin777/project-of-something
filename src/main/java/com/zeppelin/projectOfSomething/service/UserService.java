package com.zeppelin.projectOfSomething.service;

import com.zeppelin.projectOfSomething.pojo.User;

public interface UserService {

  User getUserByEmail(String email);

  User getUserByEmailAndPassword(String email, String password);

  User save(User user);

  Boolean existsByEmail(String email);
}
