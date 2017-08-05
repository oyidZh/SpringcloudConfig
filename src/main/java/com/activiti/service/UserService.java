package com.activiti.service;

import com.activiti.mapper.UserMapper;
import com.activiti.pojo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 12490 on 2017/8/1.
 */
public interface UserService {

    public List<User> getUserInfo();
}
