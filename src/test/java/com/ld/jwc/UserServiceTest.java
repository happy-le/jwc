package com.ld.jwc;

import com.ld.jwc.bean.User;
import com.ld.jwc.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * test
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public List<User> getAllUser() {
        System.out.println( userService.getAllUser());
        return null;
    }
}
