package com.bookstore.learn.spring.demo.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这里没有把CDPlayer&SgtPeppers声明为组件,但是通过使用@Bean在Java显示配置了,也同样可以,方法只关心返回值和注解声明,不关注方法名
 * 
 * @author Dragon
 *
 */
@Configuration
public class CDPlayerConfig {

	@Bean
	public CompactDisc compactDisc() {
		return new SgtPeppers();
	}

	@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc) {
		return new CDPlayer(compactDisc);
	}

}
