package com.scst.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.scst.result.Result;
import com.scst.entity.Course;
import com.scst.mapper.StudentScoreMapper;
import com.scst.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 *
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentScoreMapper studentScoreMapper;
    @GetMapping("/{currentPage}/{pageSize}")
    public Result getAll(@PathVariable Long currentPage, @PathVariable Long pageSize, Course course) {
        IPage page = courseService.selectCourseByPage(currentPage, pageSize, course);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = courseService.selectCourseByPage(page.getPages(), pageSize, course);
        }
        return new Result(page != null, page);

    }

    @PostMapping
    public Result save(@RequestBody Course course) throws IOException {
        String teacherName = course.getTeacherName().trim();
        course.setTeacherName(teacherName);
        String courseName = course.getCourseName().trim();
        course.setCourseName(courseName);
        if(courseName.isEmpty() || course.getCredit() == null || teacherName.isEmpty()){
            throw new NullPointerException();
        }
        boolean flag = courseService.save(course);
        return new Result(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Course course = courseService.getById(id);
        boolean flag = course != null;
        return new Result(flag, flag ? course : "数据同步失败-_-!");
    }

    @PutMapping
    public Result update(@RequestBody Course course) throws IOException {
        String teacherName = course.getTeacherName().trim();
        course.setTeacherName(teacherName);
        String courseName = course.getCourseName().trim();
        course.setCourseName(courseName);
        if(teacherName.isEmpty() || course.getCredit() == null || courseName.isEmpty()){
            throw new NullPointerException();
        }

        boolean flag = courseService.saveOrUpdate(course);
        return new Result(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @Transactional
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        studentScoreMapper.deleteBycId(id);
        boolean flag = courseService.removeById(id);
        return new Result(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }
}
