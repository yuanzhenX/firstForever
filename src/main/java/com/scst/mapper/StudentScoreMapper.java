package com.scst.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.scst.entity.StudentScore;
import com.scst.vo.StudentScoreVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentScoreMapper extends BaseMapper<StudentScore> {

    @Select("SELECT ss.id,ss.s_id,ss.score,s.student_name,c.course_name FROM t_student_score ss " +
            "LEFT JOIN t_student s ON ss.s_id = s.id " +
            "LEFT JOIN t_course c ON ss.c_id = c.id " +
            "${ew.customSqlSegment}")
    // 多表条件分页查询
    public IPage<StudentScoreVO> selectStudentScoreVOByPage(IPage<StudentScoreVO> page, @Param(Constants.WRAPPER) Wrapper<StudentScoreVO> wrapper);

    @Select("SELECT * from t_student_score where s_id = #{studentId}")
    public List<StudentScore> getByStudentId(Integer studentId);

    @Select("SELECT * from t_student_score where c_id = #{courseId}")
    public List<StudentScore> getByCourseId(Integer courseId);

    @Delete("delete from t_student_score where s_id = #{id}")
    void deleteBysId(Integer id);

    @Delete("delete from t_student_score where c_id = #{id}")
    void deleteBycId(Integer id);

    @Select("SELECT * FROM t_student_score where s_id = #{sId} and c_id = #{cId}")
    StudentScore getBysIdAndcId(StudentScore studentScore);
}
