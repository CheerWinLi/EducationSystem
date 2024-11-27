package com.school.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
/**
 * (Major)实体类
 *
 * @author makejava
 * @since 2024-05-08 11:16:22
 */
@Data
@TableName(value="major")
public class Major implements Serializable {
    private static final long serialVersionUID = 832006766802180283L;

     /**
     主键
     */
     @TableId(type = IdType.AUTO)
     private Integer id;

     /**
     专业名称
     */
    @TableField(value="major_name")
    private String majorName;



}

