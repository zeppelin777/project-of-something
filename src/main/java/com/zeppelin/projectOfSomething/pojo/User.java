package com.zeppelin.projectOfSomething.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

  private Integer userId;

  private String userName;

  private String email;

  private String password;

  private Integer role;

  private Date registerTime;

  private Date dateCreated;
}
