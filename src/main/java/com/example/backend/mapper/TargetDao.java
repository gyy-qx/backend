package com.example.backend.mapper;

import com.example.backend.model.Target;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TargetDao {
    int deleteByPrimaryKey(String courseName);

    int insert(Target record);

    int insertSelective(Target record);

    Target selectByPrimaryKey(String courseName);

    int updateByPrimaryKeySelective(Target record);

    int updateByPrimaryKey(Target record);
}
