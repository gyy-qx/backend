package com.example.backend.mapper;

import com.example.backend.model.Character;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CharacterDao {
    int deleteByPrimaryKey(String courseName);

    int insert(Character record);

    int insertSelective(Character record);

    Character selectByPrimaryKey(String courseName);

    int updateByPrimaryKeySelective(Character record);

    int updateByPrimaryKey(Character record);
}
