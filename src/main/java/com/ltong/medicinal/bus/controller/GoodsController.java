package com.ltong.medicinal.bus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ltong.medicinal.bus.entity.Goods;
import com.ltong.medicinal.bus.mapper.GoodsMapper;
import com.ltong.medicinal.bus.service.GoodsService;
import com.ltong.medicinal.bus.vo.GoodsVo;
import com.ltong.medicinal.util.common.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName com.ltong.medicinal.bus.controller.GoodsController
 * @Created by LTong
 * @since 2020-06-19 下午 3:13
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsService goodsService;

    /**
     * 拿出全部商品
     * @param goodsVo
     * @return
     */
    @RequestMapping("loadAllGoods")
    public AjaxResult loadAllGoods(GoodsVo goodsVo, HttpServletRequest request) {
        IPage<Goods> page = new Page<>(goodsVo.getPage(), goodsVo.getLimit());
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(goodsVo.getName()), "g.name", goodsVo.getName());
        if(goodsVo.getState() != null){
            if(goodsVo.getState() > 0){
                queryWrapper.eq(goodsVo.getState() != null, "g.state", goodsVo.getState());
            }
        }
        goodsMapper.loadAllGoods(page, queryWrapper);
        return new AjaxResult(page.getTotal(), page.getRecords());

    }

    @RequestMapping("/listPage")
    public String listPage(){
        return "goods/list";
    }

    /**
     * 改变商品的状态
     * @param goodsVo
     * @return
     */
    @RequestMapping("updateState")
    public AjaxResult updateState(GoodsVo goodsVo) {
        try {
            goodsService.updateById(goodsVo);
            return AjaxResult.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.fillInStackTrace();
            return AjaxResult.UPDATE_ERROR;
        }
    }

    /**
     * 跳转到添加商品页面
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage(){
        return "goods/add";
    }

    /**
     * 跳转到编辑商品的页面
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(){
        return "goods/edit";
    }

    /**
     * 添加商品
     * @param goodsVo
     * @return
     */
    @RequestMapping("addGoods")
    public AjaxResult addGoods(GoodsVo goodsVo){
        try {
            goodsService.save(goodsVo) ;
            return AjaxResult.ADD_SUCCESS ;
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.ADD_ERROR ;
        }
    }


    /**
     * 更新商品
     * @param goodsVo
     * @return
     */
    @RequestMapping("updateGoods")
    public AjaxResult updateGoods(GoodsVo goodsVo){
        try {
            goodsService.updateById(goodsVo) ;
            return AjaxResult.UPDATE_SUCCESS ;
        }catch (Exception e){
            e.printStackTrace();
            return  AjaxResult.UPDATE_ERROR ;
        }
    }

    /**
     * 删除商品
     * @param goodsVo
     * @return
     */
    @RequestMapping("deleteGoods")
    public AjaxResult deleteGoods(GoodsVo goodsVo){
        try {
            goodsService.removeById(goodsVo) ;
            return AjaxResult.DELETE_SUCCESS ;
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.DELETE_ERROR ;
        }
    }




}
