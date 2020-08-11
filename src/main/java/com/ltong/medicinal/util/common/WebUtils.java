package com.ltong.medicinal.util.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Created by LTong
 * @since 2020-06-17 上午 11:54
 */
public class WebUtils {
    /**
     * 得到request
     * @return
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }

    /**
     * 得到session
     * @return
     */
    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 得到当前线程的请求对象
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        return getServletRequestAttributes().getRequest();
    }

    /**
     * 得到session对象
     */
    public static HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }
}
