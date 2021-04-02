package com.example.backend.mapper;

import com.example.backend.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherDao {
    int deleteByPrimaryKey(Integer teacherNumber);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherNumber);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);


    int insert(Teacher record);
}
