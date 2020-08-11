package com.ltong.medicinal.bus.vo;

import com.ltong.medicinal.bus.entity.Address;
import com.ltong.medicinal.bus.entity.Orders;
import com.ltong.medicinal.bus.entity.OrdersDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Created by LTong
 * @since 2020-06-19 上午 11:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrdersVo extends Orders {
    private Integer page = 1 ;
    private Integer limit = 10 ;

}
