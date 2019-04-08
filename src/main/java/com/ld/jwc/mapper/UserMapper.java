package com.ld.jwc.mapper;

import com.ld.jwc.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author miaoguangqiang on 2019-04-04
 * @version 1.0
 */
@Mapper
public interface UserMapper {

    List<User> getAllUser();

    List<User> getAllUserByStatus(@Param("recordStatus") int recordStatus);

    User getInfoByUid(@Param("uid") Integer uid);

    List<User> loadUserByUsername(@Param("username") String username);

    int addUser(User user);

    int updateUserTypeByUid(@Param("userType") int userType, @Param("uid") int uid);

    int updateRecordStatusByUid(@Param("recordStatus") int recordStatus, @Param("uid") int uid);
}
