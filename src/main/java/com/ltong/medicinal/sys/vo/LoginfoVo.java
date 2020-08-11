package com.ltong.medicinal.sys.vo;

import com.ltong.medicinal.sys.entity.Loginfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Created by LTong
 * @since 2020-06-18 下午 1:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginfoVo extends Loginfo {
    private Integer page = 1 ;
    private  Integer limit = 10 ;
    //接收多个id
    private Integer[] ids;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
