package com.ld.jwc.mapper;

import com.ld.jwc.bean.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author miaoguangqiang on 2019-04-08
 * @version 1.0
 */
@Mapper
public interface JobMapper {

    List<Job> getAllJobs();

    List<Job> getJobsByUid(@Param("uid") int uid);

    int addJob(@Param("newJob") Job job);
}
