package com.bookstore.learn.spring.demo.environment;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/environment/env.properties")
@PropertySource("classpath:/environment/env2.properties")
//@Profile("active")
public class EnviromentConfig {
	

}
