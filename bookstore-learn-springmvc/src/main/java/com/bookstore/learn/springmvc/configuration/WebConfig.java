package com.bookstore.learn.springmvc.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * webConfig,重写了configureDefaultServletHandling方法,为毛？—— 配置静态资源的处理
 * 
 * @author Dragon
 *
 */

// 以下注释是从RootConfig中迁移过来的,还没测试,期望迁移后做前后端分割
// , excludeFilters = {
// @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) }
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.bookstore.learn.springmvc.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	@Bean
	public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(cnm);
		return resolver;
	}

	/**
	 * Servlet3.0的multipart解析器StandardServletMultipartResolver
	 * 
	 * 该类没有属性,上传限制的具体参数要在Servlet中配置,在web.xml或者Servlet初始化类中进行配置
	 * 
	 * Servlet初始化类已经实现了WebApplicationInitializer,重写customizeRegistration()去设置即可
	 * 
	 * @return
	 * @throws IOException
	 */
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
		return new StandardServletMultipartResolver();
	}

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

	/**
	 * 
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/login").setViewName("login");

//		 registry.addRedirectViewController(urlPath, redirectUrl);
//		 registry.addStatusController(urlPath, statusCode);
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/")
		// .setCachePeriod(31556926);
		// registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	// private SpringResourceTemplateResolver templateResolver() {
	// SpringResourceTemplateResolver resolver = new
	// SpringResourceTemplateResolver();
	// resolver.setPrefix("classpath:/views/");
	// resolver.setSuffix(".html");
	// resolver.setTemplateMode(TemplateMode.HTML);
	// resolver.setApplicationContext(applicationContext);
	// return resolver;
	// }
	/**
	 * 配置Rest接口的默认内容请求类型
	 * 
	 * @param configurer
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON_UTF8);
	}
	
}

