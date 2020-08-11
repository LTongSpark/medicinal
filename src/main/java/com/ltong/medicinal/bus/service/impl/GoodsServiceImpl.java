package com.ltong.medicinal.bus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltong.medicinal.bus.entity.Goods;
import com.ltong.medicinal.bus.mapper.GoodsMapper;
import com.ltong.medicinal.bus.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName com.ltong.medicinal.bus.service.impl.GoodsServiceImpl
 * @Created by LTong
 * @since 2020-06-19 下午 4:00
 */
@Service
@Transactional
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper , Goods> implements GoodsService {
}
