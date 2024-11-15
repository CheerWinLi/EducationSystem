package com.school.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * (Score)实体类
 *
 * @author makejava
 * @since 2024-05-11 14:33:08
 */
@Data
@TableName(value = "score")
@Accessors(chain = true)
public class Score implements Serializable {
    private static final long serialVersionUID = 972527247782301805L;

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 绑定course表
     */
    @TableField(value = "course_id")
    private Integer courseId;


    @TableField(value = "student_id")
    private Integer studentId;
    /**
     * 分数
     */
    @TableField(value = "score")
    private Integer score;
}

