package com.scst.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.scst.result.Result;
import com.scst.entity.Student;
import com.scst.mapper.StudentScoreMapper;
import com.scst.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentScoreMapper studentScoreMapper;
    @GetMapping("/{currentPage}/{pageSize}")
    public Result getAll(@PathVariable Long currentPage, @PathVariable Long pageSize, Student student) {
        IPage page = studentService.selectStudentByPage(currentPage, pageSize, student);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = studentService.selectStudentByPage(page.getPages(), pageSize, student);
        }
        return new Result(page != null, page);
    }

    @PostMapping
    public Result save(@RequestBody Student student){
        String studentName = student.getStudentName().trim();
        student.setStudentName(studentName);
        if(studentName.isEmpty() || student.getAge() == null){
            throw new NullPointerException();
        }
        boolean flag = studentService.save(student);
        return new Result(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Student student = studentService.getById(id);
        boolean flag = student != null;
        return new Result(flag, flag ? student : "数据同步失败-_-!");
    }

    @PutMapping
    public Result update(@RequestBody Student student) throws IOException {
        String studentName = student.getStudentName().trim();
        student.setStudentName(studentName);
        if(studentName.isEmpty() || student.getAge() == null){
            throw new NullPointerException();
        }
        boolean flag = studentService.saveOrUpdate(student);
        return new Result(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @Transactional
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        studentScoreMapper.deleteBysId(id);
        Student student = new Student();
        boolean flag = student.deleteById(id);
        return new Result(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }
}
