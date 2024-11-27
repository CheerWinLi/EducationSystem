package com.school.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Academy)实体类
 *
 * @author makejava
 * @since 2024-05-08 11:16:23
 */
@Data
@TableName(value = "academy")
@Accessors(chain = true)
public class Academy implements Serializable {
    private static final long serialVersionUID = 741510411386183662L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 学院名称
     */
    @TableField(value = "name")
    private String name;
}

