package com.scst.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scst.entity.StudentScore;
import com.scst.vo.StudentScoreVO;
import com.scst.mapper.StudentScoreMapper;
import com.scst.service.StudentScoreService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentScoreServiceImpl extends ServiceImpl<StudentScoreMapper, StudentScore> implements StudentScoreService {
    @Autowired
    private StudentScoreMapper studentScoreMapper;

    // 多表条件分页查询
    public IPage<StudentScoreVO> selectStudentScoreVOByPage(Long currentPage, Long pageSize, StudentScoreVO studentScoreVO) {
        IPage<StudentScoreVO> page = new Page<>(currentPage, pageSize);  //设置当前页号和分页大小
        QueryWrapper<StudentScoreVO> wrapper = new QueryWrapper<>();
        String courseName = studentScoreVO.getCourseName();
        String studentName = studentScoreVO.getStudentName();
        if (Strings.isNotEmpty(courseName)) wrapper.like("c.course_name", courseName);
        if (Strings.isNotEmpty(studentName)) wrapper.like("s.student_name", studentName);
        return studentScoreMapper.selectStudentScoreVOByPage(page, wrapper);
    }


    public StudentScore getBysIdAndcId(StudentScore studentScore) {
        return studentScoreMapper.getBysIdAndcId(studentScore);
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
