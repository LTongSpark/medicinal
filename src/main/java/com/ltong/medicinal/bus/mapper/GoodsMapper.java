package com.ltong.medicinal.bus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ltong.medicinal.bus.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName com.ltong.medicinal.bus.mapper.GoodsMapper
 * @Created by LTong
 * @since 2020-06-19 下午 3:52
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    @Select(value = "select g.*,t.name as typeName from goods g left join goods_type t on t.id=g.typeId ${ew.customSqlSegment}")
    IPage<Goods> loadAllGoods(IPage<Goods> page, @Param(Constants.WRAPPER)Wrapper wrapper);

}
