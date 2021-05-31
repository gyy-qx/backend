package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * target
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class Target implements Serializable {
    private Integer courseNumber;

    private String courseName;

    private String courseGrade;

    private String courseMajor;

    private Double courseWeightOne;

    private Double courseWeightTwo;

    private Double courseWeightThree;

    private Double courseWeightFour;

    private Double courseWeightFive;

    private Double courseOrdinaryTargetScore;

    private Double courseExperimentTargetScore;

    private Double courseEndingTargetScore;

    private Double ordinaryOneTargetScore;

    private Double experimentOneTargetScore;

    private Double endingOneTargetScore;

    private Double ordinaryTwoTargetScore;

    private Double experimentTwoTargetScore;

    private Double endingTwoTargetScore;

    private Double ordinaryThreeTargetScore;

    private Double experimentThreeTargetScore;

    private Double endingThreeTargetScore;

    private Double ordinaryFourTargetScore;

    private Double experimentFourTargetScore;

    private Double endingFourTargetScore;

    private Double ordinaryFiveTargetScore;

    private Double experimentFiveTargetScore;

    private Double endingFiveTargetScore;

    private static final long serialVersionUID = 1L;
}
