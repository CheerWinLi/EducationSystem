package com.school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.entity.po.Student;
import com.school.entity.vo.StudentVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@Repository
public interface StudentMapper extends BaseMapper<Student> {

    StudentVo getStudentDetails(String studentId);

    List<StudentVo> getStudentDetailsList();

    List<StudentVo> getStudentLikeDetailsList(@Param("filedName") String filedName, @Param("filedValue") String filedValue);
}
