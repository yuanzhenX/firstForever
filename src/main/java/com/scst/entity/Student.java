package com.scst.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName("t_student")
public class Student extends Model<Student> {
    private Integer id;
    private String studentName;
    private Integer age;
}
