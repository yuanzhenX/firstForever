package com.scst.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.scst.result.Result;
import com.scst.entity.StudentScore;
import com.scst.vo.StudentScoreVO;
import com.scst.service.CourseService;
import com.scst.service.StudentService;
import com.scst.service.impl.StudentScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/studentScore")
public class StudentScoreController {

    @Autowired
    private StudentScoreServiceImpl studentScoreService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @GetMapping("/{currentPage}/{pageSize}")
    public Result getAll(@PathVariable Long currentPage, @PathVariable Long pageSize, StudentScoreVO studentScoreVO) {
        IPage page = studentScoreService.selectStudentScoreVOByPage(currentPage, pageSize, studentScoreVO);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = studentScoreService.selectStudentScoreVOByPage(page.getPages(), pageSize, studentScoreVO);
        }
        return new Result(page != null, page);
    }

    @PostMapping
    public Result save(@RequestBody StudentScore studentScore) throws IOException {
        if(studentScore.getScore() == null || studentScore.getCId() == null || studentScore.getSId() == null){
            throw new NullPointerException();
        }
        if(studentService.getById(studentScore.getSId()) == null){
            return Result.error("没有该学生信息");
        }
        if(courseService.getById(studentScore.getCId()) == null){
            return Result.error("没有该课程信息");
        }
        if(studentScore.getScore() > 100 || studentScore.getScore() < 0){
            return Result.error("分数不在0-100的范围内");
        }
        if(studentScoreService.getBysIdAndcId(studentScore) != null){
            return Result.error("该学生已有该课程的成绩");
        }
        boolean flag = studentScoreService.save(studentScore);
        return new Result(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        StudentScore studentScore = studentScoreService.getById(id);
        boolean flag = studentScore != null;
        return new Result(flag, flag ? studentScore : "数据同步失败-_-!");
    }

    @PutMapping
    public Result update(@RequestBody StudentScore studentScore) throws IOException {
        if(studentScore.getScore() > 100 || studentScore.getScore() < 0){
            return new Result(false,"分数输入错误");
        }
        boolean flag = studentScoreService.saveOrUpdate(studentScore);
        return new Result(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = studentScoreService.removeById(id);
        return new Result(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }
}

