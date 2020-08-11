package com.ltong.medicinal.sys.vo;

import com.ltong.medicinal.sys.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Created by LTong
 * @since 2020-06-18 上午 9:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserVo extends SysUser {
    private Integer page = 1 ;
    private  Integer limit = 10 ;

    /**
     * 验证码
     */
    private String code;
}
