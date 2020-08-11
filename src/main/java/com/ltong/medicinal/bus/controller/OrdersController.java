package com.ltong.medicinal.bus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ltong.medicinal.bus.entity.Address;
import com.ltong.medicinal.bus.entity.Goods;
import com.ltong.medicinal.bus.entity.Orders;
import com.ltong.medicinal.bus.entity.OrdersDetail;
import com.ltong.medicinal.bus.mapper.OrdersMapper;
import com.ltong.medicinal.bus.service.AddresssService;
import com.ltong.medicinal.bus.service.GoodsService;
import com.ltong.medicinal.bus.service.OrdersDetailService;
import com.ltong.medicinal.bus.service.OrdersService;
import com.ltong.medicinal.bus.vo.OrdersVo;
import com.ltong.medicinal.util.common.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName com.ltong.medicinal.bus.controller.OrdersController
 * @Created by LTong
 * @since 2020-06-19 下午 3:39
 */
@RestController
@RequestMapping(value = "orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrdersDetailService ordersDetailService ;

    @Autowired
    private AddresssService addresssService ;

    @Autowired
    private GoodsService goodsService ;

    /**
     * 跳转到订单页面
     * @return
     */
    @RequestMapping("/listPage")
    public String listPage(){
        return "orders/list";
    }

    /**
     * 得到全部的订单
     * @param ordersVo
     * @param userId
     * @return
     */
    @RequestMapping("/loadAllOrders")
    public AjaxResult loadAllOrders(OrdersVo ordersVo, Long userId){
        ordersVo.setUid(userId);
        IPage<Orders> page = new Page<>(ordersVo.getPage(), ordersVo.getLimit());
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(ordersVo.getNickName()), "u.nickName", ordersVo.getNickName());
        if(ordersVo.getState() != null){
            if(ordersVo.getState() > 0){
                queryWrapper.eq(ordersVo.getState() != null, "o.state", ordersVo.getState());
            }
        }
        queryWrapper.orderByAsc("o.id") ;
        IPage<Orders> allOrders = ordersMapper.loadAllOrders(page, queryWrapper);

        List<OrdersDetail> ordersDetails = new ArrayList<>();
        allOrders.getRecords().forEach(order ->{
            Address address = addresssService.getById(order.getAddressId());
            if(address != null){
                address.setShdz(address.getCountry() + address.getCity() + address.getAddress()) ;
                order.setAddress(address) ;
            }
            QueryWrapper<OrdersDetail> query = new QueryWrapper<>();
            query.eq("ordersId", order.getId()) ;
            List<OrdersDetail> ordersDetail = ordersDetailService.list(query);
            ordersDetail.forEach(v -> {
                Goods goods = goodsService.getById(v.getGoodsId());
                v.setName(goods.getName()) ;
                v.setCoverImage(goods.getCoverImage()) ;
            });
            order.setOrdersDetailList(ordersDetail) ;
        });
        return new AjaxResult(page.getTotal() ,page.getRecords()) ;
    }

    /**
     * 改变商品的状态
     * @param ordersVo
     * @return
     */
    @RequestMapping("updateState")
    public AjaxResult updateState(OrdersVo ordersVo) {
        try {
            ordersService.updateById(ordersVo);
            return AjaxResult.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.fillInStackTrace();
            return AjaxResult.UPDATE_ERROR;
        }
    }
}
