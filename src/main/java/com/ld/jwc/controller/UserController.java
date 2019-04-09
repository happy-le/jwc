package com.ld.jwc.controller;

import com.ld.jwc.bean.User;
import com.ld.jwc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author miaoguangqiang on 2019-04-04
 * @version 1.0
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/allUser")
    public List<User> allUser() {
        return userService.getAllUser();
    }
}