package com.ld.jwc.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author miaoguangqiang on 2019-04-03
 * @version 1.0
 */
@Getter
@Setter
public class UserDTO {

    private Long id;

    private String uid;

    private String username;

    private String password;

    private String college;

    private String major;

    private Byte userType;

    private Byte recordStatus;

    private Date createdAt;

    private Date updatedAt;
}
