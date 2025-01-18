package com.scst.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scst.entity.Course;

public interface CourseService extends IService<Course> {
    IPage<Course> selectCourseByPage(Long currentPage, Long pageSize,Course course);
}
