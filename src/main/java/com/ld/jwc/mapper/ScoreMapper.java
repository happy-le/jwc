package com.ld.jwc.mapper;

import com.ld.jwc.bean.TotalScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author miaoguangqiang on 2019-04-04
 * @version 1.0
 */
@Mapper
public interface ScoreMapper {

    List<TotalScore> getAllScoreByUid(@Param("uid") int uid);

    List<TotalScore> getBjgScore(@Param("uid") int uid);

    List<TotalScore> getScoreByTerm(@Param("term") String term, @Param("uid") int uid);

    int addNewGrade(TotalScore totalScore);

    int deleteScoreByClassNum(@Param("classNum") String classNum, @Param("recordStatus") int recordStatus);
}
