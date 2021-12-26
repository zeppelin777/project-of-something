package com.zeppelin.projectOfSomething.service.impl;

import com.zeppelin.projectOfSomething.pojo.User;
import com.zeppelin.projectOfSomething.service.UserService;
import com.zeppelin.projectOfSomething.util.HashingAndSalt;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * The type User service.
 *
 * @author eddie
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

  @Override
  public User getUserByEmail(String email) {
    return userMapper.findByEmail(email);
  }

  @Override
  public Boolean existsUserByEmail(String email) {
    return userMapper.findByEmail(email) != null;
  }

  @Override
  public User checkUserByEmailAndPassword(String email, String password) {
    User userByEmail = userMapper.findByEmail(email);
    if (userByEmail != null && HashingAndSalt.verifyPassword(password, userByEmail.getRandomSalt(), userByEmail.getPassword())) {
      return userByEmail;
    }
    return null;
  }

  @Override
  public User save(User user) {
    user.setUsername(user.getUsername().trim());
    user.setEmail(user.getEmail().trim());
    user.setPassword(user.getPassword().trim());
    user.setCreatedDate(new Date());
    user.setRole((byte) 1);
    String randomSalt = HashingAndSalt.getRandomSalt();
    String encodedPassword = HashingAndSalt.generateEncodedPassword(user.getPassword(), randomSalt);
    user.setRandomSalt(randomSalt);
    user.setPassword(encodedPassword);
    return userMapper.save(user);
  }
}
