package com.example.backend.service;

import com.example.backend.mapper.CharacterDao;
import com.example.backend.mapper.CourseDao;
import com.example.backend.mapper.TargetDao;
import com.example.backend.model.Course;
import com.example.backend.model.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class scoreService {
    @Autowired
    CourseDao courseDao;
    @Autowired
    CharacterDao characterDao;
    @Autowired
    TargetDao targetDao;

    public List<String> select(Integer courseTeacher){
        return courseDao.select(courseTeacher);
    }

    public void insertRatio(Course course, Character character, Target target){

    }

}
