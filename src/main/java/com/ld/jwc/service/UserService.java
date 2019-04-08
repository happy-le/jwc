package com.ld.jwc.service;

import com.ld.jwc.bean.User;
import com.ld.jwc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author miaoguangqiang on 2019-04-04
 * @version 1.0
 */
@Service
@Transactional
@Component
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> userList = userMapper.loadUserByUsername(s);
        if(userList == null) {
            return new User();
        }
        return null;
    }
}
