package com.scst.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scst.entity.Course;
import com.scst.mapper.CourseMapper;
import com.scst.service.CourseService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    CourseMapper courseMapper;


    public IPage<Course> selectCourseByPage(Long currentPage, Long pageSize, Course course) {
        IPage<Course> page = new Page<>(currentPage, pageSize);  //设置当前页号和分页大小
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        String teacherName = course.getTeacherName();
        String courseName = course.getCourseName();
        Integer credit = course.getCredit();
        Integer courseId = course.getId();
        if (Strings.isNotEmpty(teacherName)) wrapper.like("teacher_name", teacherName);
        if (Strings.isNotEmpty(courseName)) wrapper.like("course_name", courseName);
        if (credit != null) wrapper.eq("credit", credit);
        if (courseId != null) wrapper.eq("id", courseId);
        return courseMapper.selectCourseByPage(page, wrapper);
    }

//    public void selectCommentVOByPage() {
//        CommentVO commentVO = new CommentVO();
//        commentVO.setContent("很");
//        commentVO.setTitle("Spring");
//        commentVO.setUserName("zhang");
//        IPage<CommentVO> page = this.selectCommentVOByPage(1L, 2L, commentVO);
//        System.out.println("数据总条数：" + page.getTotal());
//        System.out.println("总页数：" + page.getPages());
//        List<CommentVO> comments = page.getRecords(); //获取当前页中的记录
//        for (CommentVO c : comments) {
//            System.out.println("comment = " + c);
//        }
//    }
}
