package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * target_text
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class TargetText implements Serializable {
    private Integer courseNumber;

    private String courseName;

    private String courseGrade;

    private String courseMajor;

    private String courseTargetOne;

    private String courseTargetTwo;

    private String courseTargetThree;

    private String courseTargetFour;

    private String courseTargetFive;

    private String courseRequirementOne;

    private String courseRequirementTwo;

    private String courseRequirementThree;

    private String courseRequirementFour;

    private String courseRequirementFive;

    private static final long serialVersionUID = 1L;
}
