package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * result
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class Result implements Serializable {
    private Integer number;

    private String studentClass;

    private Integer studentSno;

    private String courseName;

    private Double courseOneOrdinaryScore;

    private Double courseOneExperimentScore;

    private Double courseOneEndingScore;

    private Double courseTwoOrdinaryScore;

    private Double courseTwoExperimentScore;

    private Double courseTwoEndingScore;

    private Double courseThreeOrdinaryScore;

    private Double courseThreeExperimentScore;

    private Double courseThreeEndingScore;

    private Double courseFourOrdinaryScore;

    private Double courseFourExperimentScore;

    private Double courseFourEndingScore;

    private Double courseFiveOrdinaryScore;

    private Double courseFiveExperimentScore;

    private Double courseFiveEndingScore;

    private Double courseOneAchievementDegree;

    private Double courseTwoAchievementDegree;

    private Double courseThreeAchievementDegree;

    private Double courseFourAchievementDegree;

    private Double courseFiveAchievementDegree;

    private Double courseAchievementDegree;

    private static final long serialVersionUID = 1L;
}
