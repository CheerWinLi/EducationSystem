package com.school.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.entity.po.Teacher;
import com.school.mapper.TeacherMapper;
import com.school.service.TeacherService;

import org.springframework.stereotype.Service;

/**
 * @author :Lictory
 * @date : 2024/05/15
 */

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Override
    public List<Teacher> getTeacherListByTeacherId(List<Integer> teacherId) {
        return null;
    }

    @Override
    public Integer getTeacherIdByTeacherName(String teacherName) {
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Teacher::getName, teacherName);
        return baseMapper.selectOne(wrapper).getId();
    }
}
