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

/**
 * 订单详情
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("orders_detail")
public class OrdersDetail implements Serializable {
    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 药材id
     */
    private Integer goodsId;

    /**
     * 订单编号
     */
    private Integer ordersId;

    /**
     * 购买数量
     */
    private Integer num;
    /**
     *  图书单价
     */
    private BigDecimal price;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 药材名
     */
    @TableField(exist = false)
    private String name;

    /**
     * 药草图片地址
     */
    @TableField(exist = false)
    private String coverImage;

}
