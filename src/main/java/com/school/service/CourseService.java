package com.school.service;

import java.util.List;

import com.school.entity.bo.AddCourseBo;
import com.school.entity.vo.CourseVo;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
public interface CourseService {
    /**
     * 通过获取
     *
     * @param stuId 学生id
     * @return 课程信息
     */
    List<CourseVo> getCourseByStuId(Integer stuId);



    /**
     * 通过课程名称获取课程信息
     *
     * @param courseName 课程名称
     * @return 课程信息
     */
    Integer getCourseIdByName(String courseName);

    Boolean addCourse(AddCourseBo addCourseBo);

    List<CourseVo> getCourseLikeList(String fieldName, String fieldValue);

    Boolean deleteCourse(Integer courseId, String studentId);
}
