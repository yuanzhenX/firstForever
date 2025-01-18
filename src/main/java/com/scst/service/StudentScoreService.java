package com.scst.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scst.entity.StudentScore;
import com.scst.vo.StudentScoreVO;

public interface StudentScoreService extends IService<StudentScore> {
    IPage<StudentScoreVO> selectStudentScoreVOByPage(Long currentPage, Long pageSize, StudentScoreVO studentScoreVO);

    StudentScore getBysIdAndcId(StudentScore studentScore);
}
