package com.ltong.medicinal.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltong.medicinal.sys.entity.Loginfo;
import com.ltong.medicinal.sys.mapper.LoginfoMapper;
import com.ltong.medicinal.sys.service.LoginfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Created by LTong
 * @since 2020-06-17 下午 1:12
 */
@Service
@Transactional
public class LoginfoServiceImpl extends ServiceImpl<LoginfoMapper, Loginfo> implements LoginfoService {

}
