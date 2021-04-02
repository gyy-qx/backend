package com.example.backend.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Integer studentSno;

    private String studentName;

    private String studentMajor;

    private String studentGrade;

    private String studentClass;

    private String studentSex;

    private Date studentData;

    private static final long serialVersionUID = 1L;
}