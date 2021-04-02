package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * teacher
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class Teacher implements Serializable {
    private Integer teacherNumber;

    private String teacherName;

    private String teacherSex;

    private String teacherProfessionalTitle;

    private String teacherEducation;

    private String teacherResearch;

    private String teacherTel;

    private String teacherEmail;

    private static final long serialVersionUID = 1L;
}
