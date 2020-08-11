package com.ltong.medicinal.bus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ltong.medicinal.bus.entity.Goods;
import com.ltong.medicinal.bus.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName com.ltong.medicinal.bus.mapper.OrdersMapper
 * @Created by LTong
 * @since 2020-06-19 下午 3:53
 */
public interface OrdersMapper extends BaseMapper<Orders> {

    @Select("select o.*,u.nickName,u.avatarUrl from orders o left join user u on u.id = o.uid ${ew.customSqlSegment}")
    IPage<Orders> loadAllOrders(IPage<Orders> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
