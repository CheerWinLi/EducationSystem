package com.school.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@Data
@Accessors(chain = true)
public class StudentVo {
    private Integer id;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String clazz;
    private String grade;
    private Integer studyYear;
    private String status;
    private Integer majorId;
    private String majorName;
    private Integer academyId;
    private String academyName;
    private String studentName;
    private String studentId;
}
