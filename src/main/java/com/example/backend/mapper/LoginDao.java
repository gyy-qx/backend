package com.example.backend.mapper;

import com.example.backend.model.Login;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {
    int deleteByPrimaryKey(Integer user);
    int insertSelective(Login record);
    int updateByPrimaryKeySelective(Login record);
    int updateByPrimaryKey(Login record);

    Login selectByPrimaryKey(Integer user);
    int insert(Login record);
}
