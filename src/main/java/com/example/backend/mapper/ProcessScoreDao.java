package com.example.backend.mapper;

import com.example.backend.model.ProcessScore;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProcessScoreDao {
    int deleteByPrimaryKey(Integer number);
    int insertSelective(ProcessScore record);
    int updateByPrimaryKey(ProcessScore record);

    int insert(ProcessScore record);
    int updateByPrimaryKeySelective(ProcessScore record);
    List<ProcessScore> selectByPrimaryKey(String studentMajor, String studentGrade, String courseName, String processClassification, Integer processNumber);
    List<ProcessScore> getProcessScore(Integer studentSno,String courseName);
    List<ProcessScore> selectProcessScoreByCourse(String courseName,String studentMajor, String studentGrade);
    int deleteProcessScoreByCourse(String courseName,String studentMajor, String studentGrade);
    int deleteOrdinary(String courseName,String courseMajor,String courseGrade,String processClassification,Integer processNumber);
    List<ProcessScore> selectOrdinary(String courseName,String courseMajor,String courseGrade,String processClassification,Integer processNumber);
}
