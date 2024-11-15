package com.school.service;

import java.util.List;

import com.school.entity.po.StuCourseScore;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
public interface StuClassScoreService {

    /**
     * 通过学生id查询中间表
     * @param stuId 学生id
     * @return  StuClassScore
     */
    List<StuCourseScore> getStuClassScoreByStuId(Integer stuId);

    Boolean addScore(Integer stuId, Integer courseId, Integer score);

    Boolean add(Integer stuId, Integer courseId);

    Boolean delete(String studentId, Integer courseId);

    Boolean delete(String studentId);
}
