package com.school.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-05-09 22:30:30
 */
@Data
@TableName(value="user")
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = -71221031896860152L;

     /**

     */
     @TableId(type = IdType.AUTO)
     private Integer id;

     /**
     判断是老师1还是学生0还是管理员2
     */
    @TableField(value="type")
    private Integer type;


    @TableField(value="username")
    private String username;
     /**
     密码
     */
    @TableField(value="password")
    private String password;

     /**
     关联的id
     */
    @TableField(value="relate_id")
    private Integer relateId;



}

