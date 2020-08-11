package com.ltong.medicinal.bus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltong.medicinal.bus.entity.Address;
import com.ltong.medicinal.bus.mapper.AddressMapper;
import com.ltong.medicinal.bus.service.AddresssService;
import com.ltong.medicinal.bus.vo.AddressVo;
import com.ltong.medicinal.sys.entity.Loginfo;
import com.ltong.medicinal.sys.mapper.LoginfoMapper;
import com.ltong.medicinal.sys.service.LoginfoService;
import com.ltong.medicinal.util.common.AjaxResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Created by LTong
 * @since 2020-06-17 下午 1:12
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddresssService {

}
