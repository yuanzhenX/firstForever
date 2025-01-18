package com.scst.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scst.entity.Student;
import com.scst.mapper.StudentMapper;
import com.scst.service.StudentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    StudentMapper studentMapper;


    public IPage<Student> selectStudentByPage(Long currentPage, Long pageSize, Student student) {
        IPage<Student> page = new Page<>(currentPage, pageSize);  //设置当前页号和分页大小
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        String studentName = student.getStudentName();
        Integer age = student.getAge();
        Integer studentId = student.getId();
        if (Strings.isNotEmpty(studentName)) wrapper.like("student_name", studentName);
        if (age != null) wrapper.eq("age", age);
        if (studentId != null) wrapper.eq("id", studentId);
        return studentMapper.selectStudentByPage(page, wrapper);
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
