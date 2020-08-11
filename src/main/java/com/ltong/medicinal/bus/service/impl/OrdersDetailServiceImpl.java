package com.ltong.medicinal.bus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltong.medicinal.bus.entity.OrdersDetail;
import com.ltong.medicinal.bus.mapper.OrdersDetailMapper;
import com.ltong.medicinal.bus.service.OrdersDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName com.ltong.medicinal.bus.service.impl.OrdersDetailServiceImpl
 * @Created by LTong
 * @since 2020-06-19 下午 4:01
 */
@Service
@Transactional
public class OrdersDetailServiceImpl extends ServiceImpl<OrdersDetailMapper , OrdersDetail> implements OrdersDetailService {
}
