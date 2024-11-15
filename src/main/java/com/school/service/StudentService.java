package com.school.service;

import java.util.List;

import com.school.entity.bo.AddStudentBo;
import com.school.entity.bo.LikeBo;
import com.school.entity.vo.StudentVo;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
public interface StudentService {

    /**
     * 查看学生个人信息
     * @param studentId 学生id
     * @return 学生个人信息
     */
    StudentVo getStudentDetails(String studentId);


    List<StudentVo> getStudentDetailsList();

    List<StudentVo> getStudentLikeDetailsList(LikeBo likeBo);

    Boolean addStudent(AddStudentBo addStudentBo);

    String uploadImage(MultipartFile multipartFile, Integer studentId);

    String downLoadImage(Integer studentId);

    Boolean deleteStudent(Integer studentId);
}
