package com.school.controller;

import java.util.List;

import com.school.common.CommonResult;
import com.school.entity.bo.AddStudentBo;
import com.school.entity.bo.LikeBo;
import com.school.entity.vo.StudentVo;
import com.school.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public CommonResult<StudentVo> getStudentDetails(@RequestParam("studentId") String studentId) {
        return CommonResult.autoResult(true, studentService.getStudentDetails(studentId));
    }

    @GetMapping("/student/list")
    public CommonResult<List<StudentVo>> getStudentDetailsList() {
        return CommonResult.autoResult(true, studentService.getStudentDetailsList());
    }

    @PostMapping("/student/likeList")
    public CommonResult<List<StudentVo>> getStudentLikeDetailsList(@RequestBody LikeBo likeBo) {
        return CommonResult.autoResult(true, studentService.getStudentLikeDetailsList(likeBo));
    }

    @PostMapping("/student")
    public CommonResult<Boolean> addStudent(@RequestBody AddStudentBo addStudentBo) {
        return CommonResult.autoResult(studentService.addStudent(addStudentBo));
    }

    @PostMapping("/student/image")
    public CommonResult<String> uploadImage(@RequestParam("file") MultipartFile multipartFile, @RequestParam("studentId") Integer studentId) {
        return CommonResult.autoResult(true, studentService.uploadImage(multipartFile, studentId));
    }

    @GetMapping("/student/image")
    public CommonResult<String> downLoadImage(@RequestParam("studentId") Integer studentId) {
        return CommonResult.autoResult(true, studentService.downLoadImage(studentId));
    }

    @DeleteMapping("/student")
    public CommonResult<Boolean> deleteStudent(@RequestParam("studentId") Integer studentId) {
        return CommonResult.autoResult(true, studentService.deleteStudent(studentId));
    }

}
