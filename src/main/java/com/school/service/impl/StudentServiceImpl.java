package com.school.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.entity.bo.AddStudentBo;
import com.school.entity.bo.LikeBo;
import com.school.entity.po.Student;
import com.school.entity.vo.StudentVo;
import com.school.mapper.StudentMapper;
import com.school.service.AcademyService;
import com.school.service.MajorService;
import com.school.service.StuClassScoreService;
import com.school.service.StudentService;
import com.school.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    private static final String ROOT_UPLOAD_DIR = "D:\\IDEA\\GitHubProject\\EducateSystem\\front\\public\\image";
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AcademyService academyService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private StuClassScoreService stuClassScoreService;


    @Autowired
    private UserService userService;

    @Override
    public StudentVo getStudentDetails(String studentId) {
        return studentMapper.getStudentDetails(studentId);
    }

    @Override
    public List<StudentVo> getStudentDetailsList() {
        return studentMapper.getStudentDetailsList();
    }

    @Override
    public List<StudentVo> getStudentLikeDetailsList(LikeBo likeBo) {
        return studentMapper.getStudentLikeDetailsList(likeBo.getFieldName(), likeBo.getFieldValue());
    }

    @Override
    public Boolean addStudent(AddStudentBo addStudentBo) {
        Student student = new Student();
        Integer majorId = majorService.getMajorIdByMajorName(addStudentBo.getMajorName());
        Integer academyId = academyService.getAcademyIdByAcademyName(addStudentBo.getAcademyName());
        student.setName(addStudentBo.getStudentName())
                .setPhoneNumber(addStudentBo.getPhoneNumber())
                .setAge(addStudentBo.getAge())
                .setGrade(addStudentBo.getGrade())
                .setClazz(addStudentBo.getClazz())
                .setGender(addStudentBo.getGender())
                .setAcademyId(academyId)
                .setMajorId(majorId)
                .setStudentId(addStudentBo.getStudentId())
                .setStatus("正常")
                .setStudyYear(addStudentBo.getStudyYear())
        ;
        Assert.isTrue(studentMapper.insert(student) > 0, "添加学生失败");
        userService.addUser(1, student.getId(), addStudentBo.getStudentId());
        return true;
    }

    @Override
    public String uploadImage(MultipartFile multipartFile, Integer studentId) {
        if (multipartFile.isEmpty()) {
            return null;
        }
        try {
            // 获取文件名
            String fileName = studentId + ".png";
            // 构建文件保存路径，以 studentId 为父文件夹
            String uploadDir = ROOT_UPLOAD_DIR;
            Path uploadPath = Paths.get(uploadDir);
            // 如果父文件夹不存在，则创建它
            // 构建文件路径
            Path filePath = uploadPath.resolve(fileName);
            // 将文件保存到指定路径
            Files.copy(multipartFile.getInputStream(), filePath);
            // 返回文件的访问路径，这里返回相对路径
            return "/" + studentId + "/" + fileName;
        } catch (IOException e) {
            e.printStackTrace(); // 处理异常
            return null; // 或者抛出自定义异常
        }
    }

    @Override
    public String downLoadImage(Integer studentId) {
        return ROOT_UPLOAD_DIR + "\\" + studentId + ".png";
    }

    @Override
    public Boolean deleteStudent(Integer studentId) {
        Assert.isTrue(studentMapper
                .delete(new LambdaQueryWrapper<Student>().eq(Student::getStudentId, studentId)) > 0, "删除失败");
        return true;
    }
}
