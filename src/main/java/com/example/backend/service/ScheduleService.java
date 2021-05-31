package com.example.backend.service;

import com.alibaba.fastjson.JSON;
import com.example.backend.mapper.ProcessScoreDao;
import com.example.backend.mapper.ProcessTextDao;
import com.example.backend.mapper.StudentDao;
import com.example.backend.mapper.TargetTextDao;
import com.example.backend.model.ProcessScore;
import com.example.backend.model.ProcessText;
import com.example.backend.model.TargetText;
import com.example.backend.studentDto.StudentDto1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    TargetTextDao targetTextDao;
    @Autowired
    ProcessTextDao processTextDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    ProcessScoreDao processScoreDao;


//    平时任务
    public TargetText getTargetText(String courseName,String courseMajor,String courseGrade){
        System.out.println(targetTextDao.getTargetText(courseName,courseMajor,courseGrade));
        return targetTextDao.getTargetText(courseName,courseMajor,courseGrade);
    }

    public List<ProcessText> selectOrdinary(String json){
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String courseMajor = JSON.parseObject(json).get("courseMajor").toString();
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        String processClassification = JSON.parseObject(json).get("processClassification").toString();
        return processTextDao.selectOrdinary(courseName,courseMajor,courseGrade,processClassification);
    }

    public String insertProcessText(ProcessText processText){
        Integer result= processTextDao.insert(processText);
        if(result>0){
            return "添加成功";
        }
        else{
            return "添加失败";
        }
    }
    public String deleteOrdinary(String json){
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String courseMajor = JSON.parseObject(json).get("courseMajor").toString();
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        String processClassification = JSON.parseObject(json).get("processClassification").toString();
        Integer processNumber = Integer.parseInt(JSON.parseObject(json).get("processNumber").toString());
        Integer textResult = processTextDao.deleteOrdinary(courseName,courseMajor,courseGrade,processClassification,processNumber);
        Integer selectScoreResult = (processScoreDao.selectOrdinary(courseName,courseMajor,courseGrade,processClassification,processNumber)).size();
        Integer deleteScoreResult = processScoreDao.deleteOrdinary(courseName,courseMajor,courseGrade,processClassification,processNumber);
        if(textResult>0&&selectScoreResult==deleteScoreResult){
            return "删除成功";
        }
        else{
            return "删除失败";
        }
    }

    public List<StudentDto1> getStudentByGrade(String json){
        String courseMajor = JSON.parseObject(json).get("courseMajor").toString();
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        return studentDao.getStudentByGrade(courseMajor,courseGrade);
    }

    public String insertProcessScore(List<ProcessScore> processScoreList){
        Integer result = 0;
        for(int i= 0; i<processScoreList.size() ;i++){
            result= result+ processScoreDao.insert(processScoreList.get(i));
        }
        if(result == processScoreList.size()){
            return "录入成功";
        }
        else {
            return "录入失败";
        }
    }

    public List<ProcessScore> ifHaveProcessScore(String json){
        String studentMajor = JSON.parseObject(json).get("studentMajor").toString();
        String studentGrade = JSON.parseObject(json).get("studentGrade").toString();
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String processClassification = JSON.parseObject(json).get("processClassification").toString();
        Integer processNumber =Integer.parseInt(JSON.parseObject(json).get("processNumber").toString()) ;
        if (processScoreDao.selectByPrimaryKey(studentMajor, studentGrade, courseName, processClassification, processNumber) == null) {
            return null;
        }
        else return processScoreDao.selectByPrimaryKey(studentMajor, studentGrade, courseName, processClassification, processNumber);
    }

    public String updateProcessScore(List<ProcessScore> processScoreList){
        Integer result =0;
        for(Integer i= 0;i<processScoreList.size();i++){
             result = result + processScoreDao.updateByPrimaryKeySelective(processScoreList.get(i));
        }
        if(result==processScoreList.size()){
            return "更新成功";
        }
        else{
            return "更新失败";
        }
    }

}
