package com.activiti.mapper;

import com.activiti.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 12490 on 2017/8/1.
 */
@Component
public interface UserMapper {
    List<User> findUserInfo();
}
