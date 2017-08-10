package com.bookstore.learn.springmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = { "com.bookstore.learn.springmvc.repository",
		"com.bookstore.learn.springmvc.service","com.bookstore.learn.springmvc.configuration" }, excludeFilters = {
				@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@ImportResource("classpath:springConfiguration/javaMixXML.xml")
public class RootConfig {

}
