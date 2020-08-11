package com.ltong.medicinal.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName com.ltong.medicinal.mater.sys.controller.SystemController
 * @Created by LTong
 * @since 2020-06-17 下午 1:51
 */
@Controller
@RequestMapping("sys")
public class SystemController {
    /**
     * 跳转到登陆页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "system/index/login";
    }

    /**
     * 跳转到首页
     */

    @GetMapping("index")
    public String index(){
        return "system/index/index" ;
    }

    /**
     * 跳转到工作台
     */

    @GetMapping("toDeskManager")
    public String toDeskManager(){
        return "system/index/deskManager" ;
    }

    /**
     * 跳转到图标库
     */

    @GetMapping("toIconManager")
    public String toIconManager(){
        return "system/icon/iconManager" ;
    }

    /**
     * 跳转到日志管理
     * @return
     */
    @RequestMapping("toLoginfoManager")
    public String toLoginfoManager(){
        return "system/loginfo/loginfoManager";
    }



}
