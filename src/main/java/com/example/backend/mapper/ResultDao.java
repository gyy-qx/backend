package com.example.backend.mapper;

import com.example.backend.model.Result;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ResultDao {
    int insert(Result record);

    int insertSelective(Result record);
}
