package com.example.backend.service;

import com.example.backend.mapper.TeacherDao;
import com.example.backend.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;
    public int insert(Teacher loginPerson){
        return teacherDao.insert(loginPerson);
    }
}
