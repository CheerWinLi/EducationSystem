package com.school.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2024-05-08 11:16:22
 */
@Data
@TableName(value="teacher")
public class Teacher implements Serializable {
    private static final long serialVersionUID = 362084755623826770L;

     /**
     主键
     */
     @TableId(type = IdType.AUTO)
     private Integer id;

     /**
     教师工号
     */
    @TableField(value="work_id")
    private String workId;

     /**
     教师名
     */
    @TableField(value="name")
    private String name;

     /**
     年龄
     */
    @TableField(value="age")
    private Integer age;

     /**
     性别
     */
    @TableField(value="gender")
    private String gender;

     /**
     教师电话
     */
    @TableField(value="phone_number")
    private String phoneNumber;



}

