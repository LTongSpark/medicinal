package com.ltong.medicinal.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName com.ltong.medicinal.bus.controller.BusController
 * @Created by LTong
 * @since 2020-06-21 上午 9:18
 */
@Controller
@RequestMapping(value = "bus")
public class BusController {

    /**
     * 跳转到收货人地址
     * @return
     */
    @RequestMapping("toUserManager")
    public String toAddressManager(){
        return "business/user/userManager";
    }


    /**
     * 跳转到收货人地址
     * @return
     */
    @RequestMapping("toOrdersManager")
    public String toOrderDetailManager(){
        return "business/orders/ordersManager";
    }

    /**
     * 跳转到收货人地址
     * @return
     */
    @RequestMapping("toGoodsManager")
    public String toGoodsManager(){
        return "business/goods/goodsManager";
    }

    /**
     * 跳转到药材类别
     * @return
     */
    @RequestMapping("toGoodsTypeManager")
    public String toGoodsTypeManager(){
        return "business/goodstype/goodsTypeManager";
    }
    /**
     * 跳转到轮播图
     * @return
     */
    @RequestMapping("toAdvertisementManager")
    public String toAdvertisementManager(){
        return "business/advertisement/advertisementManager";
    }
}
