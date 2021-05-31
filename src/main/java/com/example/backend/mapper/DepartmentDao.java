package com.example.backend.mapper;

import com.example.backend.model.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentDao {
    int deleteByPrimaryKey(String researchName);
    int insert(Department record);
    int insertSelective(Department record);
    Department selectByPrimaryKey(String researchName);
    int updateByPrimaryKeySelective(Department record);
    int updateByPrimaryKey(Department record);


    String getMajor(String researchName);
    List<String> getResearchList();
    Integer selectChairman(String researchName);
    String selectByNumber(Integer researchChairman);
    List<String> getAllMajor();
}
