package com.zeppelin.projectOfSomething.mapper;

import com.zeppelin.projectOfSomething.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserMapper extends JpaRepository<User, Long> {

  User findByEmail(String email);

  User findByEmailAndPassword(String email, String password);

  Boolean existsByEmail(String email);
}
