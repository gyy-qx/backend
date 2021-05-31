package com.example.backend.service;

import com.example.backend.mapper.DepartmentDao;
import com.example.backend.mapper.LoginDao;
import com.example.backend.mapper.TeacherDao;
import com.example.backend.model.Login;
import com.example.backend.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyAccountService {
    @Autowired
    DepartmentDao departmentDao;//报红，在mapper文件上加@Repository注解，这是从spring2.0新增的一个注解，用于简化 Spring 的开发，实现数据访问
    @Autowired
    LoginDao loginDao;
    @Autowired
    TeacherDao teacherDao;

    public List<String> getResearchList(){
        return departmentDao.getResearchList();
    }


    public Integer selectChairman(String researchName){
        return departmentDao.selectChairman(researchName);
    }


    public Login myAccountLogin(Integer teacherNumber){
        return loginDao.selectByPrimaryKey(teacherNumber);
    }

    public Teacher myAccountTeacher(Integer teacherNumber){
        return teacherDao.selectByPrimaryKey(teacherNumber);
    }

    public String myAccountSubmit(Teacher teacher,Login loginPerson){
        Integer loginResult = loginDao.updateByPrimaryKey(loginPerson);
        Integer teacherResult = teacherDao.updateByPrimaryKey(teacher);
        if(loginResult>0 && teacherResult> 0){
            return "修改成功";
        }
        else{
            return "修改失败";
        }
    }
}
