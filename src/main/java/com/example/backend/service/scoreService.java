package com.example.backend.service;

import com.alibaba.fastjson.JSON;
import com.example.backend.courseDto.CourseClass;
import com.example.backend.mapper.*;
import com.example.backend.model.*;
import com.example.backend.studentDto.StudentDto1;
import com.example.backend.targetDto.targetDto1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class scoreService {
    @Autowired
    CourseDao courseDao;
    @Autowired
    TargetTextDao targetTextDao;
    @Autowired
    TargetDao targetDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    ResultDao resultDao;
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    ClassResultDao classResultDao;
    @Autowired
    ProcessScoreDao processScoreDao;
    @Autowired
    ProcessTextDao processTextDao;

    public Course getCourseInformation(String json){
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String courseMajor = JSON.parseObject(json).get("courseMajor").toString();
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        return courseDao.selectByPrimaryKey(courseName,courseMajor,courseGrade);
    }

    public TargetText getCourseCharacter(String json){
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String courseMajor = JSON.parseObject(json).get("courseMajor").toString();
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        return targetTextDao.getTargetText(courseName,courseMajor,courseGrade);
    }

    public Target getCourseTarget(String json){
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String courseMajor = JSON.parseObject(json).get("courseMajor").toString();
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        return targetDao.selectByPrimaryKey(courseName,courseMajor,courseGrade);
    }

    public List<CourseClass> select(Integer courseTeacher){
        return courseDao.getAllCourseByTeacher(courseTeacher);
    }

    public List<String> getAllMajor(){
        return departmentDao.getAllMajor();
    }

    public String insertRatio(Course course,TargetText targetText, Target target){

        int courseResult =courseDao.updateByPrimaryKeySelective(course);
        int targetTextResult;
        int targetResult;
        Integer targetSelectTextResult = (targetTextDao.selectByPrimaryKey(targetText.getCourseName(),targetText.getCourseMajor(),targetText.getCourseGrade())).size();
        if(targetSelectTextResult==1){
            targetTextResult =targetTextDao.updateByPrimaryKeySelective(targetText);
        }
        else {
            targetTextResult =targetTextDao.insertSelective(targetText);
        }

        Integer targetSelectResult = (targetDao.selectKey(target.getCourseName(),target.getCourseMajor(),target.getCourseGrade())).size();
        if(targetSelectResult==1){
            targetResult =targetDao.updateByPrimaryKeySelective(target);
        }
        else {
            targetResult =targetDao.insertSelective(target);
        }
//        int targetResult =targetDao.insertSelective(target);
        if(courseResult>=1&&targetTextResult>=1&&targetResult>=1){
            return "提交成功";
        }
        else{
            return "提交失败";
        }
    }


    public List<CourseClass> getAllCourseByTeacher(Integer courseTeacher){
        System.out.println(courseDao.getAllCourseByTeacher(courseTeacher));
        return courseDao.getAllCourseByTeacher(courseTeacher);
    }


    public List<String> getClassByCourse(CourseClass courseClass){
        String studentGrade = courseClass.getCourseGrade();
        String studentMajor = courseClass.getCourseMajor();
        return studentDao.getClassByCourse(studentGrade,studentMajor);
    }

    public List<StudentDto1> getStudentByClass(String studentClass){
        return studentDao.getStudentByClass(studentClass);
    }

    public String getScoreResult(List<Result> resultList){
        Integer res = 0;
        for(int i= 0; i<resultList.size() ;i++){
            System.out.println(resultList.get(i));
            res= res+ resultDao.insertSelective(resultList.get(i));
        }
        if(res == resultList.size()){
            return "录入成功";
        }
        else {
            return "录入失败";
        }
    }

    public List<targetDto1> getTargetScore(String courseName,String CourseMajor,String courseGrade){
        System.out.println(targetDao.getTargetScore(courseName,CourseMajor,courseGrade));
        return targetDao.getTargetScore(courseName,CourseMajor,courseGrade);
    }

    public List<Result> getResultScore(String studentClass,String courseName){
        System.out.println((resultDao.getResultScore(studentClass,courseName)).size());
        if((resultDao.getResultScore(studentClass,courseName)).size()==0){
            return null;
        }
        else return resultDao.getResultScore(studentClass,courseName);
    }

    public void updateAchievementDegree(List<Result> resultList,ClassResult classResult){
        for(int i=0;i<resultList.size();i++) {
                resultDao.updateByPrimaryKeySelective(resultList.get(i));
        }
        if(classResultDao.selectByPrimaryKey(classResult.getClassName(),classResult.getCourseName())==null){
            classResultDao.insertSelective(classResult);
        }
        else classResultDao.updateByPrimaryKeySelective(classResult);
    }

    public Teacher getTeacherByNum(Integer teacherNumber){
        return teacherDao. selectByPrimaryKey(teacherNumber);
    }

    public Course getCourseOne(String courseName,String courseMajor,String courseGrade){
        return courseDao.selectByPrimaryKey(courseName,courseMajor,courseGrade);
    }

    public ClassResult getClassResult(String courseName,String className){
        return classResultDao.selectByPrimaryKey(className,courseName);
    }

    public List<Result> ifHaveScoreResult(String json){
        String studentClass = JSON.parseObject(json).get("studentClass").toString();
        String courseName = JSON.parseObject(json).get("courseName").toString();
        System.out.println(studentClass);
        System.out.println(courseName);
        System.out.println(resultDao.getResultScore(courseName,studentClass));
        if(resultDao.getResultScore(courseName,studentClass)==null){
            return null;
        }
        else return resultDao.getResultScore(studentClass,courseName);
    }

    public String updateScoreResult(List<Result> resultList){
        Integer result = 0;
        for(Integer i =0;i<resultList.size();i++){
            Integer number = resultDao.getResultScoreNumber(resultList.get(i).getCourseName(),resultList.get(i).getStudentSno());
            resultList.get(i).setNumber(number);
            System.out.println("序号是" + number);
            System.out.println(resultList.get(i));
            result = result + resultDao.updateByPrimaryKeySelective(resultList.get(i));
        }
        if(result==resultList.size()){
            return "更新成功";
        }
        else{
            return "更新失败";
        }
    }

    public List<ProcessScore> getProcessScore(String json){
        Integer studentSno = Integer.parseInt(JSON.parseObject(json).get("studentSno").toString());
        String courseName = JSON.parseObject(json).get("courseName").toString();
        return processScoreDao.getProcessScore(studentSno,courseName);
    }

    public List<ProcessText> getProcessTextIf(String json){
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String courseMajor = JSON.parseObject(json).get("courseMajor").toString();
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        return processTextDao.getProcessTextIf(courseName,courseMajor,courseGrade);
    }

}
