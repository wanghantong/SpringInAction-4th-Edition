package com.bookstore.learn.spring.task.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAsync
@ComponentScan(basePackages = { "com.bookstore.learn.spring.task.repository", "com.bookstore.learn.spring.task.service",
		"com.bookstore.learn.spring.task.cases" }, excludeFilters = {
				@Filter(type = FilterType.ANNOTATION) })
//@ComponentScan(basePackages = { "com.bookstore.learn.spring.task.repository", "com.bookstore.learn.spring.task.service",
//		"com.bookstore.learn.spring.task.cases" }, excludeFilters = {
//				@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
// @ImportResource("classpath:task/taskAsync.xml")
public class RootConfig {

}
