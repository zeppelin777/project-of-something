package com.zeppelin.projectOfSomething.service.impl;

import com.zeppelin.projectOfSomething.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Base service.
 *
 * @author admin
 */
public class BaseService {

    /**
     * The User mapper.
     */
    @Autowired
    protected UserMapper userMapper;
}