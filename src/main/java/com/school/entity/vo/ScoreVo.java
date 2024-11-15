package com.school.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author :Lictory
 * @date : 2024/05/11
 */

@Data
@Accessors(chain = true)
public class ScoreVo {
    private String studentId;
    private Integer scoreId;
    private Integer score;
    private Integer credit;
    private String studentName;
    private String teacherName;
    private Integer teacherId;
    private Integer courseId;
    private String courseName;
}
