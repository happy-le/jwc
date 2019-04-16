package com.ld.jwc.service;

import com.ld.jwc.bean.UserDTO;
import com.ld.jwc.jwc_score_job.dao.mysql.mapper.XincheDataQuality.UserMapper;
import com.ld.jwc.jwc_score_job.model.mysql.entity.JwcScoreJob.User;
import com.ld.jwc.jwc_score_job.model.mysql.entity.JwcScoreJob.UserExample;
import com.ld.jwc.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author miaoguangqiang on 2019-04-09
 * @version 1.0
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        LOGGER.info("用户{}", uid);
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUidEqualTo(uid)
                .andRecordStatusEqualTo((byte)0);
        return UserUtil.toUserDTO(this.userMapper.selectByExample(userExample).get(0));
    }

    public boolean addNewUser(UserDTO user) {
        User newUser = new User();
        newUser = UserUtil.toEntity(user);
        LOGGER.info("新用户 ： {}", newUser);
        int num = this.userMapper.insert(newUser);
        if(num > 0) {
            return true;
        }
        return false;
    }

    public boolean deleteUserByUid(String uid) {
        LOGGER.info("删除用户 ： {}", uid);
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUidEqualTo(uid);
        return this.userMapper.deleteByExample(userExample) == 1;
    }

    public boolean updatedPass(UserDTO dto, String uid) {
        LOGGER.info("updated by {}",dto);
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUidEqualTo(uid);
        return this.userMapper.updateByExampleSelective(UserUtil.toEntity(dto), userExample) == 1;
    }
}
