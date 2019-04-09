package com.ld.jwc.jwc_score_job.dao.mysql.mapper.XincheDataQuality;

import com.ld.jwc.jwc_score_job.model.mysql.entity.JwcScoreJob.TotalScore;
import com.ld.jwc.jwc_score_job.model.mysql.entity.JwcScoreJob.TotalScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TotalScoreMapper {
    long countByExample(TotalScoreExample example);

    int deleteByExample(TotalScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TotalScore record);

    int insertSelective(TotalScore record);

    List<TotalScore> selectByExample(TotalScoreExample example);

    TotalScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TotalScore record, @Param("example") TotalScoreExample example);

    int updateByExample(@Param("record") TotalScore record, @Param("example") TotalScoreExample example);

    int updateByPrimaryKeySelective(TotalScore record);

    int updateByPrimaryKey(TotalScore record);
}