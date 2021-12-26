package com.zeppelin.projectOfSomething.mapper;

import com.zeppelin.projectOfSomething.pojo.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The interface User mapper.
 *
 * @author eddie
 */
@Repository
public interface UserMapper extends JpaRepository<User, Long> {

  /**
   * Find by email user.
   *
   * @param email the email
   * @return the user
   */
  @Cacheable(value = {"users"}, key = "#email")
  User findByEmail(String email);
}
