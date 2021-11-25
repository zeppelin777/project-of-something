package com.zeppelin.projectOfSomething.mapper;

import com.zeppelin.projectOfSomething.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  boolean insert(User user);

  User getUserByEmail(String email);
}
