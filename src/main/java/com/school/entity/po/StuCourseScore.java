package com.school.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * (StuClazzScore)实体类
 *
 * @author makejava
 * @since 2024-05-08 11:16:22
 */
@Data
@TableName(value="stu_course_score")
@Accessors(chain = true)
public class StuCourseScore implements Serializable {
    private static final long serialVersionUID = -62757054473959855L;

     /**
     关联stu的主键
     */
    @TableField(value="student_id")
    private Integer studentId;

     /**
     关联course
     */
    @TableField(value="course_id")
    private Integer courseId;

     /**
     最终成绩
     */
    @TableField(value="score_id")
    private Integer scoreId;



}

