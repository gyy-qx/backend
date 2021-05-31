package com.example.backend.mapper;

import com.example.backend.model.TargetText;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TargetTextDao {
    int deleteByPrimaryKey(Integer courseNumber);
    int insert(TargetText record);
    TargetText selectByPrimaryKey(Integer courseNumber);
    int updateByPrimaryKey(TargetText record);

    int updateByPrimaryKeySelective(TargetText record);
    List<TargetText> selectByPrimaryKey(String courseName, String courseMajor, String courseGrade);
    int insertSelective(TargetText record);
    int deleteCourse(String courseName,String courseMajor,String courseGrade);
    TargetText getTargetText(String courseName,String courseMajor,String courseGrade);
}
