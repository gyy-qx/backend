package com.example.backend.mapper;

import com.example.backend.model.Target;
import com.example.backend.targetDto.targetDto1;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TargetDao {
    int deleteByPrimaryKey(Integer courseNumber);
    int insert(Target record);
    int updateByPrimaryKey(Target record);


    int updateByPrimaryKeySelective(Target record);
    int insertSelective(Target record);
    Target selectByPrimaryKey(String courseName,String courseMajor,String courseGrade);
    List<Target> selectKey(String courseName,String courseMajor,String courseGrade);
    List<targetDto1> getTargetScore(String courseName,String courseMajor,String courseGrade);
    int deleteCourse(String courseName,String courseMajor,String courseGrade);
}
