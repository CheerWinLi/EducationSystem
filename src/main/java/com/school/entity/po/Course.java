package com.school.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2024-05-08 11:16:23
 */
@Data
@TableName(value="course")
public class Course implements Serializable {
    private static final long serialVersionUID = 758281366671071714L;

     /**
     主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

     /**
     课程名称
     */
    @TableField(value="name")
    private String name;

     /**
     学分
     */
    @TableField(value="credit")
    private Integer credit;

     /**
     授课老师/关联teacher表
     */
    @TableField(value="teacher_id")
    private Integer teacherId;



}

