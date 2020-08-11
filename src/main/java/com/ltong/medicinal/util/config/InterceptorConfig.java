package com.ltong.medicinal.util.config;

import com.ltong.medicinal.util.interceptor.UrlInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName com.ltong.medicinal.util.config.InterceptorConfig
 * @Created by LTong
 * @since 2020-07-06 上午 9:46
 *
 * 拦截器配置
 * 过滤器依赖于Servlet容器，而Interceptor则为SpringMVC的一部分。
 * 过滤器能够拦截所有请求，而Interceptor只能拦截Controller的请求，所以从覆盖范围来看，Filter应用更广一些。
 * 但是在Spring逐渐一统Java框架、前后端分离越演越烈，实际上大部分的应用场景，拦截器都可以满足了。
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //需要拦截的路径，/**表示需要拦截所有请求
        String[] addPathPatterns = {"/**"};
        //不需要拦截的路径,当然要包括登录页面
        String[] excludePathPatterns = {"/resources/**","/sys/toLogin","/login/**","/error","/file/uploadFile","/sys/index"};
        //注册登录拦截器1
        //order指定执行顺序，数值越小越优先
        //可以配置多个拦截器,给registry再加一个Interceptor就可以了，不用再创建一个新的config配置类。
        //拦截器1如果未登录访问首页跳转登录页
        registry.addInterceptor(new UrlInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns)
                .order(0);
    }
}
