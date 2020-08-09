package com.mp.configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author tangmf
 * @Date 2020/1/14 10:47
 */
@Configuration
public class MyBatisPlusConfig {
	@Bean // 加入到spring容器管理
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
}
