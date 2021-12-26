package com.zeppelin.projectOfSomething.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author eddie
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User implements Serializable {

  @Id
  @GeneratedValue
  private Long userId;

  @Column(name = "username")
  private String username;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "random_salt")
  private String randomSalt;

  @Column(name = "role")
  private Byte role;

  @Column(name = "login_date")
  private Date loginDate;

  @Column(name = "created_date")
  private Date createdDate;
}
