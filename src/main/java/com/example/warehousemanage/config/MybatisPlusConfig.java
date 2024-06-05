package com.example.warehousemanage.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//实现mybatisplus的分页查询需要使用MybatisPlusConfig配置类（需要在为拦截器添加分页拦截器），如果不添加分页拦截器，使用Page进行分页查询的结果中的records任然会是全部的数据
@Configuration
public class MybatisPlusConfig {

    /**
     * IPage的分页使用的是拦截器，属于物理分页，好处就是处理大量数据时，查询速度快。
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 创建分页拦截器
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        // 向MybatisPlus拦截器链中添加分页拦截器
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }
}

