package com.bookstore.learn.spring.task.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * webConfig,重写了configureDefaultServletHandling方法,为毛？—— 配置静态资源的处理
 * 
 * @author Dragon
 *
 */
//@Configuration
//启用Spring MVC
//@EnableWebMvc
//启用组件扫描 
//@ComponentScan("com.bug.trace.controllor")
public class WebConfig extends WebMvcConfigurerAdapter {
	/**
	 * 配置JSP视图解析
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	/**
	 * 配置静态资源的处理
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * 配置视图解析器,暂不处理
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
	}

}
