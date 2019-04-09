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
public class TotalScore {

    private Integer id;

    private String uid;

    private String classNum;

    private String className;

    private String noId;

    private Double credit;

    private String examTime;

    private Double grade;

    private Integer recordStatus;

    private String term;

    private Date createdAt;

    private Date updatedAt;
}
