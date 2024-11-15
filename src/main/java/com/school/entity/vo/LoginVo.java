package com.school.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author :Lictory
 * @date : 2024/05/08
 */
@Data
@Accessors(chain = true)
public class LoginVo {


    private String studentId;
    /**
     * 代表是学生/老师/管理员
     */
    private Integer status;
}
