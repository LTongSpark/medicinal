package com.ltong.medicinal.bus.vo;

import com.ltong.medicinal.bus.entity.GoodsType;
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
public class GoodsTypeVo extends GoodsType {
    private Integer page = 1;
    private Integer limit = 10;

}
