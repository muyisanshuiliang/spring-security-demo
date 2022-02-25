package com.example.dss.service.impl;

import com.example.dss.domain.User;
import com.example.dss.mapper.UserMapper;
import com.example.dss.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        if (logger.isDebugEnabled()){
            logger.debug("获取用户信息");
        }
        return userMapper.getUserByName(name);
    }
}
