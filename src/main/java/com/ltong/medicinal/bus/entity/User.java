package com.ltong.medicinal.bus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 小程序端登录的用户
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {


    //尚未获取用户信息
    public static final String NOT_GET_USERINFO = "0";
    //已获取用户信息
    public static final String HAVE_GET_USERINFO = "1";

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 微信用户openid
     */
    private String openid;

    /**
     * 用户昵称
     */

    private String nickName;

    /**
     * 用户性别0未知，1男，2，女
     */
    private Integer gender;

    /**
     * 用户头像图片
     */
    private String avatarUrl;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 省
     */
    private String city;

    /**
     * 是否已获取用户信息
     */
    private String haveGetUserInfo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 守货人
     */
    @TableField(exist = false)
    private String name;
    /**
     * 电话
     */
    @TableField(exist = false)
    private String phone;
    /**
     * 收货地址
     */
    @TableField(exist = false)
    private String shdz;
    /**
     * 地址状态
     */
    @TableField(exist = false)
    private Integer state;

}
