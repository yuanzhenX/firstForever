package com.scst.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.scst.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Select("SELECT * FROM t_student  " +
            "${ew.customSqlSegment}")
    // 多表条件分页查询
    public IPage<Student> selectStudentByPage(IPage<Student> page, @Param(Constants.WRAPPER) Wrapper<Student> wrapper);
}
