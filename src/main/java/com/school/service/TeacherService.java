package com.school.service;

import java.util.List;

import com.school.entity.po.Teacher;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
public interface TeacherService {

    List<Teacher> getTeacherListByTeacherId(List<Integer> teacherId);

    Integer getTeacherIdByTeacherName(String teacherName);
}
