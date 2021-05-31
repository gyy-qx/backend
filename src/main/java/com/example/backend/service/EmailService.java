package com.example.backend.service;

import com.alibaba.fastjson.JSON;
import com.example.backend.mapper.EmailDao;
import com.example.backend.mapper.TeacherDao;
import com.example.backend.model.Email;
import com.example.backend.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    EmailDao emailDao;
    @Autowired
    TeacherDao teacherDao;


    public String emailToTeacher(Email email){
        Integer result = emailDao.insert(email);
        if(result>0){
            return "发送成功";
        }
        else {
            return "发送失败";
        }
    }

    public List<Email> getEmailByTeacher(String json){
        Integer courseTeacher = Integer.parseInt(JSON.parseObject(json).get("courseTeacher").toString());
        return emailDao.selectByTeacher(courseTeacher);
    }

    public void updateEmailState(Email email){
        String courseName = email.getCourseName();
        String courseMajor = email.getCourseMajor();
        String courseGrade = email.getCourseGrade();
        Integer courseTeacher = email.getCourseTeacher();
        String emailTitle = email.getEmailTitle();
        String emailContent = email.getEmailContent();
        String emailTime = email.getEmailTime();
        String emailState = email.getEmailState();
        Integer num = emailDao.selectNum(courseName,courseMajor,courseGrade,courseTeacher,emailTitle,emailContent,emailState,emailTime);
        email.setNum(num);
        if(email.getEmailState().equals("0")){
            email.setEmailState("1");
        }else {
            email.setEmailState("0");
        }
        emailDao.updateByPrimaryKey(email);
    }

    public String deleteEmail(Email email){
        String courseName = email.getCourseName();
        String courseMajor = email.getCourseMajor();
        String courseGrade = email.getCourseGrade();
        Integer courseTeacher = email.getCourseTeacher();
        String emailTitle = email.getEmailTitle();
        String emailContent = email.getEmailContent();
        String emailTime = email.getEmailTime();
        String emailState = email.getEmailState();
        Integer num = emailDao.selectNum(courseName,courseMajor,courseGrade,courseTeacher,emailTitle,emailContent,emailState,emailTime);
        int result = emailDao.deleteByPrimaryKey(num);
        if(result>0)
            return "删除成功";
        else
            return "删除失败";
    }

    public String getEmailPersonName(String json){
        Integer emailTeacher =Integer.parseInt (JSON.parseObject(json).get("emailTeacher").toString());
        Teacher teacher = teacherDao.selectByPrimaryKey(emailTeacher);
        return teacher.getTeacherName();
    }

    public String updateEmailStateAll(List<Email> emailList){
        Integer result = 0;
        for(int i = 0;i<emailList.size();i++){
            emailList.get(i).setEmailState("1");
            result = result + emailDao.updateByPrimaryKeySelective(emailList.get(i));
        }
        if(emailList.size()==result)
            return "全部已读";
        else return "已读失败";
    }


}
