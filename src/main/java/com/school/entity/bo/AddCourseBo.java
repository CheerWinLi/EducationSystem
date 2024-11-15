package com.school.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author :Lictory
 * @date : 2024/05/15
 */

@Data
@Accessors(chain = true)
public class AddCourseBo {
    private String courseName;
    private String teacherName;
    private Integer credit;
    private Integer studentId;
}
