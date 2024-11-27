package com.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.entity.bo.AddCourseBo;
import com.school.entity.po.Course;
import com.school.entity.vo.CourseVo;
import com.school.mapper.CourseMapper;
import com.school.service.CourseService;
import com.school.service.StuClassScoreService;
import com.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private StuClassScoreService stuClassScoreService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseVo> getCourseByStuId(Integer stuId) {
        return baseMapper.getCourseListByStuId(stuId);
    }

    @Override
    public Integer getCourseIdByName(String courseName) {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Course::getName, courseName);
        return baseMapper.selectOne(wrapper).getId();
    }


    @Override
    public Boolean addCourse(AddCourseBo addCourseBo) {
        Integer teacherId = teacherService.getTeacherIdByTeacherName(addCourseBo.getTeacherName());
        Course course = new Course();
        course.setName(addCourseBo.getCourseName());
        course.setTeacherId(teacherId);
        course.setCredit(addCourseBo.getCredit());
        courseMapper.insert(course);
        stuClassScoreService.add(addCourseBo.getStudentId(), course.getId());
        return true;
    }

    @Override
    public List<CourseVo> getCourseLikeList(String fieldName,String fieldValue) {
        return courseMapper.getCourseLikeList(fieldName, fieldValue);
    }

    @Override
    public Boolean deleteCourse(Integer courseId, String studentId) {
        stuClassScoreService.delete(studentId, courseId);
        return true;
    }
}
