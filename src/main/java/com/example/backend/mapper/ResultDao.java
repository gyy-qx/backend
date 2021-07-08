package com.example.backend.mapper;

import com.example.backend.model.Result;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ResultDao {
    int deleteByPrimaryKey(Integer number);
    int insert(Result record);
    int updateByPrimaryKey(Result record);
    Result selectByPrimaryKey(Integer number);


    int insertSelective(Result record);
    List<Result> getResultScore(String studentClass, String courseName);
    List<Result> getResultScoreByGrade(String courseName);
    int updateByPrimaryKeySelective(Result record);
    int getResultScoreNumber(String courseName,Integer studentSno);
}
