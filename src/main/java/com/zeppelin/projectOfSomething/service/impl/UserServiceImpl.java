package com.zeppelin.projectOfSomething.service.impl;

import com.zeppelin.projectOfSomething.pojo.User;
import com.zeppelin.projectOfSomething.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {

  @Override
  public User getUserByEmail(String email) {
    return userMapper.findByEmail(email);
  }

  @Override
  public User getUserByEmailAndPassword(String email, String password) {
    return userMapper.findByEmailAndPassword(email, password);
  }

  @Override
  public User save(User user) {
    return userMapper.save(user);
  }

  @Override
  public Boolean existsByEmail(String email) {
    return userMapper.existsByEmail(email);
  }
}
