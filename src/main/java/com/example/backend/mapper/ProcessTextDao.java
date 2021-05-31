package com.example.backend.mapper;

import com.example.backend.model.ProcessText;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProcessTextDao {
    int insertSelective(ProcessText record);
    ProcessText selectByPrimaryKey(Integer number);
    int updateByPrimaryKeySelective(ProcessText record);
    int updateByPrimaryKey(ProcessText record);

    int insert(ProcessText record);
    int deleteOrdinary(String courseName, String courseMajor, String courseGrade, String processClassification,Integer processNumber);
    List<ProcessText> selectOrdinary(String courseName, String courseMajor, String courseGrade, String processClassification);
    List<ProcessText> getProcessTextIf(String courseName, String courseMajor, String courseGrade);
}
