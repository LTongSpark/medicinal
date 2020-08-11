package com.ltong.medicinal.bus.vo;

import com.ltong.medicinal.bus.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Created by LTong
 * @since 2020-06-19 上午 11:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserVo extends User {
    private Integer page = 1;
    private Integer limit = 10;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    //尚未获取用户信息
    public static final String NOT_GET_USERINFO = "0";
    //已获取用户信息
    public static final String HAVE_GET_USERINFO = "1";
}
