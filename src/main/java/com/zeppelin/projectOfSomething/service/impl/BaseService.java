package com.zeppelin.projectOfSomething.service.impl;

import com.zeppelin.projectOfSomething.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    protected UserMapper userMapper;
}