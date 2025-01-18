package com.scst.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    @Bean //配置分页插件
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean //配置SQL性能分析插件，该插件只用于开发环境，不建议生产环境使用。
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //设置SQL是否格式化
        performanceInterceptor.setFormat(true);
        //设置SQL最大执行时间（ms），超过时间会抛出异常。
        performanceInterceptor.setMaxTime(150);
        return performanceInterceptor;
    }
}
