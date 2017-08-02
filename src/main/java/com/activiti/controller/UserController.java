package com.activiti.controller;

import com.activiti.pojo.User;
import com.activiti.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * Created by 12490 on 2017/8/1.
 */
@Controller
public class UserController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /*
     *  http://localhost:8080/getUserInfo
     */

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo(HttpSession session) {
        List<User> userList = userService.getUserInfo();
        session.setAttribute("userList", JSONObject.toJSONString(userList));
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        User user = userList.get(0);
        return user;
    }
}

