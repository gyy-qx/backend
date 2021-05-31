package com.example.backend.mapper;

import com.example.backend.model.Email;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmailDao {
    int insertSelective(Email record);
    int updateByPrimaryKey(Email record);

    int insert(Email record);
    List<Email> selectByTeacher(Integer courseTeacher);
    int updateByPrimaryKeySelective(Email record);
    int deleteByPrimaryKey(Integer num);
    int selectNum(String courseName,String courseMajor,String courseGrade,Integer courseTeacher,String emailTitle,String emailContent,String emailState,String emailTime);
}
