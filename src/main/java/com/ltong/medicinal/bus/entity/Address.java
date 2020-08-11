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
 * 收货地址
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("address")
public class Address implements Serializable {
    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 市级
     */
    private String country;
    /**
     * 地州级
     */
    private String city;
    /**
     * 微信用户id
     */
    private Integer uid;
    /**
     * 创建时间
     */
    private Date cjsj;
    /**
     * 更新时间
     */
    private Date gxsj;
    /**
     * 状态 1有效
     */
    private Integer state;

    @TableField(exist = false)
    private String shdz ;

}
