package com.zeppelin.projectOfSomething;

import com.zeppelin.projectOfSomething.mapper.UserMapper;
import com.zeppelin.projectOfSomething.pojo.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisTest {

    Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void redisTests() {
        while (true) {
            try {
                User user = userMapper.findByEmail("139420666@qq.com");
                logger.error(user.toString());
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
