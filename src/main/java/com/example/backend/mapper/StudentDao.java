package com.example.backend.mapper;

import com.example.backend.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentDao {
    int deleteByPrimaryKey(Integer studentSno);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentSno);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
