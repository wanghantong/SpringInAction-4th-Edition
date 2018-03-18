package com.bookstore.learn.spring.task.classscan.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = { "com.bookstore.learn.spring.task.classscan.configuration" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION) })
public class ClassRootConfig {

}
