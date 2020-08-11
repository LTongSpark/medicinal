package com.ltong.medicinal.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台管理员
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser implements Serializable {
    private static final long serialVersionUID=1L;

    /**
     *主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 登录名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 创建时间
     */
    private Date cjsj;
    /**
     * 修改时间
     */
    private Date gxsj;
    /**
     * 盐
     */
    private String salt ;/**
     * 盐
     */
    private String token ;

}
