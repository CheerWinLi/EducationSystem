package com.school.controller;

import java.util.List;

import com.school.common.CommonResult;
import com.school.entity.bo.AddCourseBo;
import com.school.entity.bo.LikeBo;
import com.school.entity.vo.CourseVo;
import com.school.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course/list")
    public CommonResult<List<CourseVo>> getCourseListByStuId(Integer studentId) {
        return CommonResult.success(courseService.getCourseByStuId(studentId));
    }

    @PostMapping("/course/likeList")
    public CommonResult<List<CourseVo>> getCourseLikeList(@RequestBody LikeBo likeBo) {
        return CommonResult.success(courseService.getCourseLikeList(likeBo.getFieldName(), likeBo.getFieldValue()));
    }

    @PostMapping("/course")
    public CommonResult<Boolean> addCourse(@RequestBody AddCourseBo addCourseBo) {
        return CommonResult.autoResult(courseService.addCourse(addCourseBo));
    }

    @DeleteMapping("/course")
    public CommonResult<Boolean> deleteCourse(@RequestParam(value = "courseId") Integer courseId, @RequestParam(value = "studentId") String studentId) {
        return CommonResult.autoResult(courseService.deleteCourse(courseId, studentId));
    }

}
