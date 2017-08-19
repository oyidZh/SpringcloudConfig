package com.activiti.mapper;

import com.activiti.pojo.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 12490 on 2017/8/1.
 */
@Repository
public interface UserMapper {

    User findUserInfo(String emailAddr);

    int insertUser(User user);
}
