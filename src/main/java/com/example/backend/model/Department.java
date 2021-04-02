package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * department
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class Department implements Serializable {
    /**
     * 教研室名称
     */
    private String researchName;

    /**
     * 教研室主任
     */
    private Integer researchChairman;

    private String researchTel;

    private static final long serialVersionUID = 1L;
}
