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
 * 药材
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("goods")
public class Goods implements Serializable {
    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;


    /**
     *  简介
     */
    private String des;

    /**
     * 图片
     */
    private String coverImage;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     *  分类名称
     */
    private Integer typeId;



    /**
     *  是否精品
     */
    private Integer ishot;

    /**
     *  状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 主键
     */
    @TableField(exist = false)
    private String typeName;
    /**
     * 搜索
     */
    @TableField(exist = false)
    private String keyword;



}
