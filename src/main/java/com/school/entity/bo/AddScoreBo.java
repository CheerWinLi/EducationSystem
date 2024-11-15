package com.school.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author :Lictory
 * @date : 2024/05/15
 */

@Data
@Accessors(chain = true)
public class AddScoreBo {

    private Integer score;
    private Integer courseId;
    private String courseName;
    private String studentName;
    private Integer studentId;
}
