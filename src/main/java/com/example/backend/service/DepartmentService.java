package com.example.backend.service;

import com.example.backend.mapper.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;//报红，在mapper文件上加@Repository注解，这是从spring2.0新增的一个注解，用于简化 Spring 的开发，实现数据访问
    public List<String> getResearchList(){
        return departmentDao.getResearchList();
    }


    public Integer selectChairman(String researchName){
        return departmentDao.selectChairman(researchName);
    }
}
