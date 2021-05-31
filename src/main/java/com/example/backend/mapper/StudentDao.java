package com.example.backend.mapper;

import com.example.backend.model.Student;
import com.example.backend.studentDto.StudentDto1;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    int deleteByPrimaryKey(Integer studentSno);
    int insertSelective(Student record);
    Student selectByPrimaryKey(Integer studentSno);
    int updateByPrimaryKeySelective(Student record);
    int updateByPrimaryKey(Student record);

    List<String> selectMajor(String studentMajor,String studentGrade);
    int insert(Student record);
    List<String> getGrade();
    List<Student> selectByClass(String studentClass);
    List<String> getClassByCourse(String studentGrade,String studentMajor);
    List<String> getClassByMajor(String studentMajor);
    List<StudentDto1> getStudentByClass(String studentClass);
    List<StudentDto1> getStudentByGrade(String courseMajor,String courseGrade);
}
