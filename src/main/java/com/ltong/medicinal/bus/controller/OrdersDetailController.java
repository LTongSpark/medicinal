package com.ltong.medicinal.bus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ltong.medicinal.bus.entity.OrdersDetail;
import com.ltong.medicinal.bus.service.OrdersDetailService;
import com.ltong.medicinal.bus.vo.OrdersDetailVo;
import com.ltong.medicinal.util.common.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName com.ltong.medicinal.bus.controller.OrdersDetailController
 * @Created by LTong
 * @since 2020-06-19 下午 3:43
 */
@RestController
@RequestMapping("ordersDetail")
public class OrdersDetailController {

    @Autowired
    private OrdersDetailService ordersDetailService;


    /**
     * 跳转到订单详情页面
     *
     * @return
     */
    @RequestMapping("/listPage")
    public String listPage() {
        return "ordersDetail/list";
    }

    /**
     * 得到全部的订单详情
     *
     * @param ordersDetailVo
     * @return
     */
    @RequestMapping("loadAllOrderDetail")
    public AjaxResult loadAllOrderDetail(OrdersDetailVo ordersDetailVo) {
        IPage<OrdersDetail> page = new Page<>(ordersDetailVo.getPage(), ordersDetailVo.getLimit());
        QueryWrapper<OrdersDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ordersDetailVo.getId() != null, "id", ordersDetailVo.getId());
        queryWrapper.eq(ordersDetailVo.getGoodsId() != null, "goodsId", ordersDetailVo.getGoodsId());
        queryWrapper.eq(ordersDetailVo.getOrdersId() != null, "ordersId", ordersDetailVo.getOrdersId());
        ordersDetailService.page(page, queryWrapper);
        return new AjaxResult(page.getTotal(), page.getRecords());
    }

    /**
     * 跳转到添加订单订单页面
     *
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage() {
        return "ordersDetail/add";
    }

    /**
     * 更新订单页面
     *
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage() {
        return "ordersDetail/edit";
    }


    /**
     * 添加
     *
     * @param ordersDetailVo
     * @return
     */
    @RequestMapping("addOrderDetailType")
    public AjaxResult addOrderDetailType(OrdersDetailVo ordersDetailVo) {
        try {
            ordersDetailService.save(ordersDetailVo);
            return AjaxResult.ADD_SUCCESS;
        } catch (Exception e) {
            return AjaxResult.ADD_ERROR;
        }
    }

    /**
     * 修改
     *
     * @param ordersDetailVo
     * @return
     */
    @RequestMapping("updateOrderDetailType")
    public AjaxResult updateOrderDetailType(OrdersDetailVo ordersDetailVo) {
        try {
            ordersDetailService.updateById(ordersDetailVo);
            return AjaxResult.ADD_SUCCESS;
        } catch (Exception e) {
            return AjaxResult.ADD_ERROR;
        }
    }

}
