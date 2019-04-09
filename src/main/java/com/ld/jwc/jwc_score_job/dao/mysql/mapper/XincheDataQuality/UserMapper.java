package com.ld.jwc.jwc_score_job.dao.mysql.mapper.XincheDataQuality;

import com.ld.jwc.jwc_score_job.model.mysql.entity.JwcScoreJob.User;
import com.ld.jwc.jwc_score_job.model.mysql.entity.JwcScoreJob.UserExample;
import com.ld.jwc.jwc_score_job.model.mysql.entity.JwcScoreJob.UserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(UserKey key);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(UserKey key);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}