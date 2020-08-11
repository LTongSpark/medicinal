package com.ltong.medicinal.bus.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ltong.medicinal.bus.entity.Goods;
import com.ltong.medicinal.bus.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName com.ltong.medicinal.bus.service.OrdersService
 * @Created by LTong
 * @since 2020-06-19 下午 3:57
 */
public interface OrdersService extends IService<Orders> {

}
