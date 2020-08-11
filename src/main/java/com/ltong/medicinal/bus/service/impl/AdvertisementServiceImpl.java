package com.ltong.medicinal.bus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltong.medicinal.bus.entity.Advertisement;
import com.ltong.medicinal.bus.mapper.AdvertisementMapper;
import com.ltong.medicinal.bus.service.AdvertisementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName com.ltong.medicinal.bus.service.impl.AdvertisementServiceImpl
 * @Created by LTong
 * @since 2020-06-19 下午 3:58
 */
@Service
@Transactional
public class AdvertisementServiceImpl extends ServiceImpl<AdvertisementMapper , Advertisement> implements AdvertisementService {
}
