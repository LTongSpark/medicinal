package com.ltong.medicinal.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltong.medicinal.sys.entity.SysUser;
import com.ltong.medicinal.sys.mapper.SysUserMapper;
import com.ltong.medicinal.sys.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Created by LTong
 * @since 2020-06-17 下午 1:06
 */
@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


}
