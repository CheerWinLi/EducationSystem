package com.school.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author :Lictory
 * @date : 2024/05/08
 */

@Data
@Accessors(chain = true)
public class CourseVo {
    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生id
     */
    private String studentId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;
    /**
     * 学分
     */
    private Integer credit;
}
