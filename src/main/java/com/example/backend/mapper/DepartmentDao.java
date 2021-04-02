package com.example.backend.mapper;

import com.example.backend.model.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentDao {
    int deleteByPrimaryKey(String researchName);
    int insert(Department record);
    int insertSelective(Department record);
    Department selectByPrimaryKey(String researchName);
    int updateByPrimaryKeySelective(Department record);
    int updateByPrimaryKey(Department record);

    List<String> getResearchList();
    Integer selectChairman(String researchName);
}
