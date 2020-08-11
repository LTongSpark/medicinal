package com.ltong.medicinal.bus.vo;

import com.ltong.medicinal.bus.entity.Advertisement;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName com.ltong.medicinal.bus.vo.Advertisement
 * @Created by LTong
 * @since 2020-06-19 下午 3:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdvertisementVo extends Advertisement {

    private Integer page = 1 ;
    private Integer limit = 10 ;
}
