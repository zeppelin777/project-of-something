package com.zeppelin.projectOfSomething.service.impl;

import com.zeppelin.projectOfSomething.pojo.User;
import com.zeppelin.projectOfSomething.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {

  @Override
  public User getUserByEmail(String email) {
    return userMapper.getUserByEmail(email);
  }

  @Override
  public boolean insert(User user) {
    return userMapper.insert(user);
  }
}
