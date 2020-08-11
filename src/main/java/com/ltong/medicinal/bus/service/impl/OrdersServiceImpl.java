package com.ltong.medicinal.bus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltong.medicinal.bus.entity.Orders;
import com.ltong.medicinal.bus.mapper.OrdersMapper;
import com.ltong.medicinal.bus.service.OrdersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName com.ltong.medicinal.bus.service.impl.OrdersServiceImpl
 * @Created by LTong
 * @since 2020-06-19 下午 4:02
 */
@Service
@Transactional
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
}
