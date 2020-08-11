package com.ltong.medicinal.util.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName com.ltong.medicinal.util.config.MybatisPlusConfig
 * @Created by LTong
 * @since 2020-06-21 上午 8:39
 */
@Configuration
@ConditionalOnClass(value = {PaginationInterceptor.class})
@MapperScan(basePackages = {"com.ltong.medicinal.*.mapper"})
public class MybatisPlusConfig {
    /**
     *   mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor()
                .setDialectType("mysql");
    }
}