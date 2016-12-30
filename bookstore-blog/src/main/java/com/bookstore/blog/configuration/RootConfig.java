package com.bookstore.blog.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Service & Repository两层的声明式配置
 * @Configuration:标识为配置类
 * @ImportResource("classpath:applicationContext.xml"):引入配置文件,因为依赖第三方的配置了,所以没有摒弃xml配置
 * @EnableTransactionManagement:开启事务管理
 * @ComponentScan:当前配置扫描的包路径,@Filter作用:------未知
 * 
 * @author Dragon
 *
 */
@Configuration
@ImportResource("classpath:applicationContext.xml")
@ComponentScan(basePackages = { "com.bookstore.blog.repository.*", "com.bookstore.blog.service.*" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@EnableTransactionManagement
public class RootConfig {

}
