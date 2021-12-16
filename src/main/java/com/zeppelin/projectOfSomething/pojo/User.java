package com.zeppelin.projectOfSomething.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

  private Integer userId;

  private String username;

  private String email;

  private String password;

  private Integer role;

  private Date loginDate;

  private Date createdDate;
}
