package com.ld.jwc.util;

import com.ld.jwc.bean.UserDTO;
import com.ld.jwc.jwc_score_job.model.mysql.entity.JwcScoreJob.User;

/**
 * @author miaoguangqiang on 2019-04-09
 */
public class UserUtil {

    public static UserDTO toUserDTO(User entity) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(entity.getId());
        userDTO.setUid(entity.getUid());
        userDTO.setUsername(entity.getUsername());
        userDTO.setCollege(entity.getCollege());
        userDTO.setMajor(entity.getMajor());
        userDTO.setPassword(entity.getPassword());
        userDTO.setUserType(entity.getUserType());
        userDTO.setRecordStatus(entity.getRecordStatus());
        userDTO.setCreatedAt(entity.getCreatedAt());
        userDTO.setUpdatedAt(entity.getUpdatedAt());

        return userDTO;
    }

    public static User toEntity(UserDTO userDTO) {
        User userEntity = new User();

        userEntity.setId(userDTO.getId());
        userEntity.setUid(userDTO.getUid());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setCollege(userDTO.getCollege());
        userEntity.setMajor(userDTO.getMajor());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setUserType(userDTO.getUserType());
        userEntity.setRecordStatus(userDTO.getRecordStatus());
        userEntity.setCreatedAt(userDTO.getCreatedAt());
        userEntity.setUpdatedAt(userDTO.getUpdatedAt());

        return userEntity;
    }
}
