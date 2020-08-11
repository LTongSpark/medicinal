package com.ltong.medicinal.bus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ltong.medicinal.bus.entity.GoodsType;
import com.ltong.medicinal.bus.service.GoodsTypeService;
import com.ltong.medicinal.bus.vo.GoodsTypeVo;
import com.ltong.medicinal.util.common.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName com.ltong.medicinal.bus.controller.GoodsTypeController
 * @Created by LTong
 * @since 2020-06-19 下午 3:36
 * 商品分类标签
 */
@RestController
@RequestMapping("goodsType")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService ;

    /**
     * 跳转到商品列表的页面
     * @return
     */
    @RequestMapping("/listPage")
    public String listPage(){
        return "goodsType/list";
    }

    /**
     * 得到全部的商品列表
     * @param goodsTypeVo
     * @return
     */
    @RequestMapping("loadAllGoodsType")
    public AjaxResult loadAllGoodsType(GoodsTypeVo goodsTypeVo){
        IPage<GoodsType> page = new Page<>(goodsTypeVo.getPage() ,goodsTypeVo.getLimit()) ;
        QueryWrapper<GoodsType> queryWrapper = new QueryWrapper<>() ;
        if(goodsTypeVo.getState() != null){
            if(goodsTypeVo.getState() > 0){
                queryWrapper.eq(goodsTypeVo.getState() != null, "state", goodsTypeVo.getState());
            }
        }
        queryWrapper.eq(goodsTypeVo.getId() != null, "id", goodsTypeVo.getId());
        queryWrapper.like(StringUtils.isNotBlank(goodsTypeVo.getName()), "name", goodsTypeVo.getName()) ;
        goodsTypeService.page(page ,queryWrapper) ;
        return new AjaxResult(page.getTotal() ,page.getRecords()) ;
    }

    /**
     * 跳转到添加商品列表的页面
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage(){
        return "goodsType/add";
    }

    /**
     * 跳转到编辑商品列表的页面
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(){
        return "goodsType/edit";
    }

    /**
     * 添加商品列表
     * @param goodsTypeVo
     * @return
     */
    @RequestMapping("addGoodsType")
    public AjaxResult addGoodsType(GoodsTypeVo goodsTypeVo){
        try {
            goodsTypeService.save(goodsTypeVo) ;
            return  AjaxResult.ADD_SUCCESS ;
        }catch (Exception e){
            return  AjaxResult.ADD_ERROR ;
        }
    }

    /**
     * 修改商品列表
     * @param goodsTypeVo
     * @return
     */
    @RequestMapping("updateGoodsType")
    public AjaxResult updateGoodsType(GoodsTypeVo goodsTypeVo){
        try {
            goodsTypeService.updateById(goodsTypeVo) ;
            return  AjaxResult.UPDATE_SUCCESS ;
        }catch (Exception e){
            return  AjaxResult.UPDATE_ERROR ;
        }
    }

    /**
     * 改变商品列表的状态
     * @param goodsTypeVo
     * @return
     */
    @RequestMapping("updateGoodsTypeState")
    public AjaxResult updateGoodsTypeState(GoodsTypeVo goodsTypeVo){
        try {
            goodsTypeService.updateById(goodsTypeVo) ;
            return  AjaxResult.ADD_SUCCESS ;
        }catch (Exception e){
            return  AjaxResult.ADD_ERROR ;
        }
    }

    /**
     * 删除商品类别
     *
     * @param id
     * @return
     */
    @RequestMapping("deleteGoodsType")
    public AjaxResult deleteGoodsType(Integer id) {
        try {
            goodsTypeService.removeById(id);
            return AjaxResult.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.DELETE_ERROR;
        }
    }


}
