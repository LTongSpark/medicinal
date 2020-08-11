package com.ltong.medicinal.util.interceptor;
import com.ltong.medicinal.sys.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @ClassName com.ltong.medicinal.util.interceptor.UrlInterceptor
 * @Created by LTong
 * @since 2020-07-06 上午 9:42
 */
@Slf4j
public class UrlInterceptor implements HandlerInterceptor {
    /**
     * controller方法调用前调用
     * 如果未登录则跳转登录页
     *
     * @return 往下执行则返回true，否则返回false
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理
        if ("XMLHttpRequest".equals(request.getHeader("x-Requested-with"))) {
            log.info("登陆拦截器1执行,请求地址:" + request.getRequestURI() + "  AJAX请求放行");
            //不拦截ajax请求
            return true;
        }
        if ("true".equals(request.getHeader("iswx"))) {
            log.info("登陆拦截器1执行,请求地址:" + request.getRequestURI() + "  WX请求放行");
            //不拦截微信请求
            return true;
        }
        log.info("登陆拦截器1执行,请求地址:" + request.getRequestURI());

        //获取session中的user
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        //如果为空
        if (user == null) {
            log.info("当前用户未登录,跳转登录页面");
            //重定向到登陆页
            response.sendRedirect(request.getContextPath() + "tologin");
            return false;
        } else {
            log.info("当前用户已登录，登录的用户名为： " + user.getUsername());
        }
        return true;
    }

    /**
     * controller方法调用后视图渲染前执行。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * controller方法调用且视图渲染完成后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
