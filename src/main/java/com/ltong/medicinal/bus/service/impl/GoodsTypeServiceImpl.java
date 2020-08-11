package com.ltong.medicinal.bus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltong.medicinal.bus.entity.GoodsType;
import com.ltong.medicinal.bus.mapper.GoodsTypeMapper;
import com.ltong.medicinal.bus.service.GoodsTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName com.ltong.medicinal.bus.service.impl.GoodsTypeServiceImpl
 * @Created by LTong
 * @since 2020-06-19 下午 4:00
 */
@Service
@Transactional
public class GoodsTypeServiceImpl extends ServiceImpl<GoodsTypeMapper , GoodsType> implements GoodsTypeService {
}
