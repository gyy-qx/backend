package com.example.backend.mapper;

import com.example.backend.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CourseDao {
    int deleteByPrimaryKey(String courseName);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(String courseName);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);



    List<String> select(Integer teacherNum);
}
