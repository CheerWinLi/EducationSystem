package com.school.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2024-05-08 11:16:21
 */
@Data
@Accessors(chain = true)
@TableName(value = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 383279191068720074L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 性别
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 电话
     */
    @TableField(value = "phone_number")
    private String phoneNumber;

    /**
     * 班级
     */
    @TableField(value = "clazz")
    private String clazz;

    /**
     * 入学年份
     */
    @TableField(value = "study_year")
    private Integer studyYear;

    /**
     * 学籍状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 所属专业/关联专业表
     */
    @TableField(value = "major_id")
    private Integer majorId;

    /**
     * 所属学院id/关联学院表
     */
    @TableField(value = "academy_id")
    private Integer academyId;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 学号
     */
    @TableField(value = "student_id")
    private String studentId;

    @TableField(value = "grade")
    private String grade;
}

