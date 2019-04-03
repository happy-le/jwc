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

    int getCountByName(@Param("username") String username);

    int addUser(@Param("uid") int uid, @Param("usernname") String username, @Param("password") String password, @Param("college") String college, @Param("major") String major, @Param("userType") int userType);

    int updateUserTypeByUid(@Param("userType") int userType);

    int updateRecordStatus(@Param("uid") int uid);
}
