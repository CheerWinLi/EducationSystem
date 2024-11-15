package com.school.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author :Lictory
 * @date : 2024/05/14
 */
@Data
@Accessors(chain = true)
public class AddStudentBo {
    private String studentName;
    private String gender;
    private String studentId;
    private Integer majorId;
    private Integer studyYear;
    private String grade;
    private Integer age;
    private String clazz;
    private String phoneNumber;
    private String academyName;
    private String majorName;
    private Integer academyId;
}
