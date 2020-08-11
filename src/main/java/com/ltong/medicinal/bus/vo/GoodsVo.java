package com.ltong.medicinal.bus.vo;

import com.ltong.medicinal.bus.entity.Goods;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Created by LTong
 * @since 2020-06-19 上午 11:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsVo extends Goods {
    private Integer page = 1 ;
    private Integer limit = 10 ;

}
