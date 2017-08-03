package com.activiti.service;

import com.activiti.mapper.UserMapper;
import com.activiti.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 12490 on 2017/8/1.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

//    @Cacheable(value="userList")
    public List<User> getUserInfo(){
        List<User> user=userMapper.findUserInfo();
        System.out.println("去数据库里面查数据");
        return user;
    }
}
