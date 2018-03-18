package com.bookstore.learn.spring.demo.autoInject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/setter.properties")
public class ExpressConfig {
	@Autowired
	Environment env;

	@Bean
	public BlankDisc getDisk() {
		return new BlankDisc(env.getProperty("title"), env.getProperty("artist"));
	}
}
