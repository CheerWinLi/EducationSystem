package com.school.service;

import com.school.entity.bo.AddStudentBo;
import com.school.entity.bo.LikeBo;
import com.school.entity.vo.StudentVo;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

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
