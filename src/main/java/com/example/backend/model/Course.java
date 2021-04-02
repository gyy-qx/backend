package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * course
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class Course implements Serializable {
    private String courseName;

    private String courseEnglish;

    private String courseClassification;

    private String courseCharacter;

    private String courseTerm;

    private Double courseCredit;

    private Integer courseClassHour;

    private String courseMajor;

    private String courseExaminationMethod;

    private String courseSpecificMethod;

    private String courseAdvancedPlacement;

    private Integer courseTeacher;

    private static final long serialVersionUID = 1L;
}
