package com.scst.vo;

import lombok.Data;

@Data
public class StudentScoreVO {
    private Integer id;
    private Integer sId;
    private Double score;
    private String studentName;
    private String courseName;
}
