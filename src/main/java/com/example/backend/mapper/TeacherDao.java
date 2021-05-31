package com.example.backend.mapper;

import com.example.backend.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherDao {
    int insertSelective(Teacher record);
    int updateByPrimaryKeySelective(Teacher record);


    Teacher selectByPrimaryKey(Integer teacherNumber);
    int updateByPrimaryKey(Teacher record);
    int deleteByPrimaryKey(Integer teacherNumber);
    List<Teacher> selectAllTeacher(String teacherResearch);
    int insert(Teacher record);
    List<String> selectTeacherName();
    Integer getTeacherNumber(String teacherName);
    String getTeacherName(Integer teacherNumber);
}
