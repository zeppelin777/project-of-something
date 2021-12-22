package com.zeppelin.projectOfSomething.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
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

  @Column(name = "role")
  private Byte role;

  @Column(name = "loginDate")
  private Date loginDate;

  @Column(name = "createdDate")
  private Date createdDate;
}
