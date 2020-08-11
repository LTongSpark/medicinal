package com.ltong.medicinal.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ltong.medicinal.sys.entity.Loginfo;
import com.ltong.medicinal.sys.service.LoginfoService;
import com.ltong.medicinal.sys.vo.LoginfoVo;
import com.ltong.medicinal.util.common.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Created by LTong
 * @since 2020-06-18 下午 1:53
 */
@RestController
@RequestMapping("loginfo")
public class LoginfoController {

    @Autowired
    private LoginfoService loginfoService;

    /**
     * 查询所有的日志信息
     */
    @RequestMapping("loadAllLoginfo")
    public AjaxResult loadAllLoginfo(LoginfoVo loginfoVo) {

        IPage<Loginfo> page = new Page<>(loginfoVo.getPage(), loginfoVo.getLimit());
        QueryWrapper<Loginfo> queryWrapper = new QueryWrapper<>();
        //进行模糊查询
        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginname()), "loginname", loginfoVo.getLoginname());
        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginip()), "loginip", loginfoVo.getLoginip());
        //时间进行比对
        queryWrapper.ge(loginfoVo.getStartTime() != null, "logintime", loginfoVo.getStartTime());
        queryWrapper.le(loginfoVo.getEndTime() != null, "logintime", loginfoVo.getEndTime());
        queryWrapper.orderByDesc("logintime");
        loginfoService.page(page ,queryWrapper) ;
        return new AjaxResult(page.getTotal(), page.getRecords());
    }

    /**
     * 删除单条日志
     *
     * @param id
     * @return
     */
    @RequestMapping("deleteLoginfo")
    public AjaxResult deleteLoginfo(Integer id) {
        try {
            loginfoService.removeById(id);
            return AjaxResult.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.DELETE_ERROR;
        }
    }

    /**
     * 批量删除日志数据
     */

    @RequestMapping("batchDeleteLoginfo")
    public AjaxResult batchDeleteLoginfo(LoginfoVo loginfoVo) {
        try {
            Collection<Serializable> idList = new ArrayList<>();
            for (Integer id : loginfoVo.getIds()) {
                idList.add(id);
            }
            loginfoService.removeByIds(idList);
            return AjaxResult.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.DELETE_ERROR;
        }
    }

}
