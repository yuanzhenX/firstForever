package com.scst.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scst.entity.Student;

public interface StudentService extends IService<Student> {
    IPage<Student> selectStudentByPage(Long currentPage, Long pageSize, Student student);
}
