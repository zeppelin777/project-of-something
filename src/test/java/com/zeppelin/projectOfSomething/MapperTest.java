package com.zeppelin.projectOfSomething;

import com.zeppelin.projectOfSomething.mapper.UserMapper;
import com.zeppelin.projectOfSomething.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class MapperTest {

    @Autowired
    private UserMapper userMapper;

    Logger logger = LoggerFactory.getLogger(MapperTest.class);

    public User cacheableTest(String email) {
        logger.error("not use cache");
        return userMapper.findByEmail(email);
    }
}
