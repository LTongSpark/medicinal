package com.ltong.medicinal.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.ltong.medicinal.sys.entity.Loginfo;
import com.ltong.medicinal.sys.service.LoginfoService;
import com.ltong.medicinal.sys.vo.SysUserVo;
import com.ltong.medicinal.util.common.ActiverUser;
import com.ltong.medicinal.util.common.AjaxResult;
import com.ltong.medicinal.util.common.WebUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @Created by LTong
 * @since 2020-06-17 下午 9:53
 */
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginfoService loginfoService;

    @RequestMapping("login")
    public AjaxResult login(SysUserVo sysUserVo, HttpSession session) {
        //获得存储在session的code
        String code = (String) session.getAttribute("code");
        if (StringUtils.isNotBlank(code) && code.equals(sysUserVo.getCode().toLowerCase())) {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken usernamePasswordToken = new UsernamePasswordToken(sysUserVo.getUsername(), sysUserVo.getPassword());
            try {
                subject.login(usernamePasswordToken);
                ActiverUser user = (ActiverUser) subject.getPrincipal();
                //将user存储到session中
                WebUtils.getSession().setAttribute("user", user.getSysUser());
                //记录登陆日志
                Loginfo entity = new Loginfo();
                entity.setLoginname(user.getSysUser().getName() + "-" + user.getSysUser().getUsername());
                entity.setLoginip(WebUtils.getRequest().getRemoteAddr());
                entity.setLogintime(new Date());
                loginfoService.save(entity);
                return AjaxResult.LOGIN_SUCCESS;
            } catch (AuthenticationException e) {
                e.printStackTrace();
                return AjaxResult.LOGIN_ERROR_PASS;
            }
        } else {
            return AjaxResult.LOGIN_ERROR_CODE;
        }
    }

    /**
     * 得到用户登陆验证码
     */

    @RequestMapping("getCode")
    public void getCode(HttpServletResponse httpServletResponse, HttpSession httpSession) {
//定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 5);
        httpSession.setAttribute("code", lineCaptcha.getCode());
        try {
            ServletOutputStream outputStream = httpServletResponse.getOutputStream();
            lineCaptcha.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping("loginOut")
    public AjaxResult loginOut(HttpSession session) {
        session.setAttribute("user", "");
        return AjaxResult.success("登出成功");
    }
}
