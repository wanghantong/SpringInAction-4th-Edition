package com.bookstore.learn.springmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//,"com.bookstore.learn.springmvc.service","com.bookstore.learn.springmvc.configuration" 

//期望转移到webConfig中,否则单测会启动SpringWeb
//, excludeFilters = {
//@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) }
@Configuration
@ComponentScan(basePackages = { "com.bookstore.learn.springmvc.service", "com.bookstore.learn.springmvc.repository",
		"com.bookstore.learn.springmvc.configuration" })
// "classpath:springConfiguration/javaMixXML.xml",
@ImportResource({ "classpath:database/druid.xml" })
// @EnableTransactionManagement
public class RootConfig {

}
