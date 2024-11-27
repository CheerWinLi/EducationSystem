package com.school.service;

import com.school.entity.po.Teacher;

import java.util.List;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
public interface TeacherService {

    List<Teacher> getTeacherListByTeacherId(List<Integer> teacherId);

    Integer getTeacherIdByTeacherName(String teacherName);
}
