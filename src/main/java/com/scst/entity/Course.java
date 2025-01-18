package com.scst.entity;

import lombok.Data;

/**
 *
 */
@Data
public class Course {
    private Integer id;
    private String courseName;
    private String teacherName;
    private Integer credit;
}
