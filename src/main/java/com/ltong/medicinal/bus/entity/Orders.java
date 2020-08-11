package com.ltong.medicinal.bus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单基本信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("orders")
public class Orders implements Serializable {
    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单金额
     */
    private BigDecimal totalPrice;

    /**
     * 用户姓名
     */
    private Long uid;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 订单状态
     */
    private Integer state;

    /**
     * 收货人地址id
     */
    private Integer addressId;



    /**
     *  创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     *  收货人对象
     */
    @TableField(exist = false)
    private Address address;

    /**
     * 微信用户昵称
     */
    @TableField(exist = false)
    private String nickName;

    /**
     * 头像地址
     */
    @TableField(exist = false)
    private String avatarUrl;

    /**
     * 订单详情
     */
    @TableField(exist = false)
    private List<OrdersDetail> ordersDetailList;


}
