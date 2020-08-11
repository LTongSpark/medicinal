package com.ltong.medicinal.bus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ltong.medicinal.bus.entity.Address;
import com.ltong.medicinal.bus.service.AddresssService;
import com.ltong.medicinal.bus.vo.AddressVo;
import com.ltong.medicinal.util.common.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName com.ltong.medicinal.bus.controller.AddressController
 * @Created by LTong
 * @since 2020-06-19 下午 3:11
 */
@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddresssService addresssService;

    @RequestMapping("/listPage")
    public String listPage() {
        return "address/list";
    }

    /**
     * 查询这个用户的所有地址
     *
     * @param addressVo
     * @return
     */
    @RequestMapping("loadAllAddress")
    public AjaxResult loadAllAddress(AddressVo addressVo) {
        IPage<Address> page = new Page<>(addressVo.getPage(), addressVo.getLimit());
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();

        queryWrapper.gt(addressVo.getState() != null, "state", 0);
        queryWrapper.eq(addressVo.getId() != null, "id", addressVo.getId());
        //进行模糊查询
        queryWrapper.like(StringUtils.isNotBlank(addressVo.getName()), "name", addressVo.getName());
        queryWrapper.eq(StringUtils.isNotBlank(addressVo.getPhone()), "phone", addressVo.getPhone());
        queryWrapper.eq(StringUtils.isNotBlank(addressVo.getCity()), "city", addressVo.getCity());
        queryWrapper.eq(StringUtils.isNotBlank(addressVo.getCountry()), "country", addressVo.getCountry());
        IPage<Address> addressIPage = addresssService.page(page, queryWrapper);
        addressIPage.getRecords().forEach(v -> {
            v.setShdz(v.getCountry() + v.getCity() + v.getAddress());
        });
        return new AjaxResult(page.getTotal(), page.getRecords());
    }

    /**
     * 添加地址
     *
     * @param addressVo
     * @param userId
     * @return
     */

    @RequestMapping("add")
    public AjaxResult add(AddressVo addressVo, Integer userId) {
        try {
            addressVo.setUid(userId);
            addresssService.save(addressVo) ;
            return AjaxResult.ADD_SUCCESS ;
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.ADD_ERROR ;
        }
    }

    @RequestMapping("/editPage")
    public String editPage(){
        return "address/edit";
    }

    /**
     * 更新地址
     * @param addressVo
     * @param userId
     * @return
     */
    @RequestMapping("/update")
    public AjaxResult update(AddressVo addressVo, Integer userId){
        try {
            addressVo.setUid(userId);
            addresssService.updateById(addressVo) ;
            return AjaxResult.UPDATE_SUCCESS ;
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.UPDATE_ERROR ;
        }
    }

    /**
     * 更新地址的状态
     * @param addressVo
     * @return
     */
    @RequestMapping("/updateState")
    @ResponseBody
    public AjaxResult updateState(AddressVo addressVo){
        try {
            addresssService.updateById(addressVo);
            return  AjaxResult.UPDATE_SUCCESS ;
        }catch (Exception e){
            e.printStackTrace();
            return  AjaxResult.UPDATE_ERROR ;
        }
    }

    /**
     * 删除地址的状态
     * @param addressVo
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(AddressVo addressVo){
        try {
            addresssService.removeById(addressVo);
            return  AjaxResult.DELETE_SUCCESS ;
        }catch (Exception e){
            e.printStackTrace();
            return  AjaxResult.DELETE_ERROR ;
        }
    }



}
