package com.scst.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.scst.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    @Select("SELECT * FROM t_course c " +
            "${ew.customSqlSegment}")
    // 多表条件分页查询
    public IPage<Course> selectCourseByPage(IPage<Course> page, @Param(Constants.WRAPPER) Wrapper<Course> wrapper);
}
