package com.example.backend.mapper;

import com.example.backend.model.ClassResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ClassResultDao {
    int deleteByPrimaryKey(Integer number);
    int insert(ClassResult record);
    int updateByPrimaryKey(ClassResult record);

    int insertSelective(ClassResult record);
    ClassResult selectByPrimaryKey(String className,String courseName);
    int updateByPrimaryKeySelective(ClassResult record);
}
