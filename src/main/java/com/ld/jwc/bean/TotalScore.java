package com.ld.jwc.bean;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author miaoguangqiang on 2019-04-03
 * @version 1.0
 */
@Getter
@Setter
public class TotalScore {

    private Integer uid;

    private String classNum;

    private String className;

    private Integer noId;

    private Double credit;

    private String time;

    private Double grade;

    private Integer recordStatus;

    private String term;

    private Timestamp createdAt;
}
