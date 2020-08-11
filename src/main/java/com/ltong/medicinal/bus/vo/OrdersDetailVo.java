package com.ltong.medicinal.bus.vo;

import com.ltong.medicinal.bus.entity.OrdersDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Created by LTong
 * @since 2020-06-19 上午 11:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrdersDetailVo extends OrdersDetail {
    private Integer page = 1 ;
    private Integer limit = 10 ;


}
