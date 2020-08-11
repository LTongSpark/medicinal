package com.ltong.medicinal.bus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 分类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("goods_type")
public class GoodsType implements Serializable {
    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类别名称
     */
    private String name;

    /**
     *  状态 1 有效
     */
    private Integer state;

    /**
     *  创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
