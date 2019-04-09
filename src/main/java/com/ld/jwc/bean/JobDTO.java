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
public class JobDTO {

    private Long id;

    private String uid;

    private String address;

    private String email;

    private String company;

    private String jobName;

    private String organizer;

    private Integer actionTime;

    private String extra;

    private Byte recordStatus;

    private Date createdAt;

    private Date updatedAt;

}
