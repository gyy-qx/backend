package com.example.backend.mapper;

import com.example.backend.courseDto.CourseClass;
import com.example.backend.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseDao {
    int insert(Course record);
    Course selectByPrimaryKey(String courseName);
    int updateByPrimaryKey(Course record);


    int insertSelective(Course record);
    int deleteByPrimaryKey(String courseName,String courseMajor,String courseGrade);
    int updateByPrimaryKeySelective(Course record);
    List<String> select(Integer teacherNum);
    List<Course> selectCourse(String courseMajor);
    List<Course> selectByGrade(String courseMajor,String courseGrade);
    List<CourseClass> getAllCourseByTeacher(Integer courseTeacher);
    Course selectByPrimaryKey(String courseName,String courseMajor,String courseGrade);
    List<Course> selectByKey(String courseName,String courseMajor,String courseGrade);
}
