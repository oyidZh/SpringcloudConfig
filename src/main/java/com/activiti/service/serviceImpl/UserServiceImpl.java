package com.activiti.service.serviceImpl;

import com.activiti.mapper.UserMapper;
import com.activiti.pojo.user.User;
import com.activiti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 12490 on 2017/8/6.
 */
@Service
@EnableCaching
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "ehCache1",key = "")
    public List<User> getUserInfo() {
        return userMapper.findUserInfo();
    }
}
