package com.ltong.medicinal.bus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ltong.medicinal.bus.entity.Address;
import com.ltong.medicinal.bus.vo.AddressVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName com.ltong.medicinal.bus.mapper.AddressMapper
 * @Created by LTong
 * @since 2020-06-19 下午 3:03
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
}
