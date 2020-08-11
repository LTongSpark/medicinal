package com.ltong.medicinal.bus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ltong.medicinal.bus.entity.Advertisement;
import com.ltong.medicinal.bus.entity.Goods;
import com.ltong.medicinal.bus.service.AdvertisementService;
import com.ltong.medicinal.bus.service.GoodsService;
import com.ltong.medicinal.bus.vo.AdvertisementVo;
import com.ltong.medicinal.util.common.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName com.ltong.medicinal.bus.controller.AdvertisementController
 * @Created by LTong
 * @since 2020-06-19 下午 3:34
 */
@RestController
@RequestMapping("advertisement")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private GoodsService goodsService ;

    /**
     * 得到全部的轮廓图
     *
     * @param advertisementVo
     * @return
     */
    @RequestMapping("/loadAllAdvertisement")
    public AjaxResult loadAllAdvertisement(AdvertisementVo advertisementVo) {
        IPage<Advertisement> page = new Page<>(advertisementVo.getPage(), advertisementVo.getLimit());
        QueryWrapper<Advertisement> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(advertisementVo.getName()), "name", advertisementVo.getName());
        if(advertisementVo.getState() != null){
            if(advertisementVo.getState() > 0){
                queryWrapper.eq(advertisementVo.getState() != null, "state", advertisementVo.getState());
            }
        }
        IPage<Advertisement> advertisementIPage = advertisementService.page(page, queryWrapper);
        advertisementIPage.getRecords().forEach(v ->{
            Goods goods = goodsService.getById(v.getGoodsId());
            if(goods != null) v.setGoodsName(goods.getName()) ;
        });
        return new AjaxResult(page.getTotal(), page.getRecords());
    }


    @RequestMapping("/addPage")
    public String addPage() {
        return "advertisement/add";
    }

    /**
     * 添加轮播图
     * @param advertisementVo
     * @return
     */
    @RequestMapping("/addAdvertisement")
    public AjaxResult add(AdvertisementVo advertisementVo) {
        try {
            advertisementService.save(advertisementVo);
            return AjaxResult.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.ADD_ERROR;
        }


    }

    @RequestMapping("/editPage")
    public String editPage() {
        return "advertisement/edit";
    }

    /**
     * 更新轮播图
     * @param advertisementVo
     * @return
     */
    @RequestMapping("/updateAdvertisement")
    public AjaxResult updateAdvertisement(AdvertisementVo advertisementVo) {
        try {
            advertisementService.updateById(advertisementVo);
            return AjaxResult.UPDATE_SUCCESS ;
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.UPDATE_ERROR;
        }

    }

    /**
     * 改变轮播图的显示与不显示
     * @param advertisementVo
     * @return
     */

    @RequestMapping("/updateState")
    public AjaxResult updateState(AdvertisementVo advertisementVo) {
        try {
            advertisementService.updateById(advertisementVo);
            return AjaxResult.UPDATE_SUCCESS ;
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.UPDATE_ERROR;
        }
    }

    /**
     * 删除轮播图
     * @param advertisementVo
     * @return
     */
    @RequestMapping("deleteAdvertisement")
    public AjaxResult deleteAdvertisement(AdvertisementVo advertisementVo){
        try {
            advertisementService.removeById(advertisementVo) ;
            return AjaxResult.DELETE_SUCCESS ;
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.DELETE_ERROR ;
        }
    }
}
