package com.ltong.medicinal.bus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltong.medicinal.bus.entity.User;
import com.ltong.medicinal.bus.mapper.UserMapper;
import com.ltong.medicinal.bus.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName com.ltong.medicinal.bus.service.impl.UserServiceImpl
 * @Created by LTong
 * @since 2020-06-19 下午 4:03
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper , User> implements UserService {
}
