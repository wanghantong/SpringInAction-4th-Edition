package com.bookstore.learn.springmvc.configuration;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bookstore.learn.springmvc.filters.DemoFilter;
import com.bookstore.learn.springmvc.filters.DemoFilter2;
import com.bookstore.learn.springmvc.listener.DemoListener;
import com.bookstore.learn.springmvc.service.MyFilter;

/**
 * DispatcherServlet
 * 
 * @author Dragon
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		FilterRegistration.Dynamic addFilter = context.addFilter("DemoFilter2", new DemoFilter2());
		addFilter.addMappingForUrlPatterns(null, true, "/","*map");
		super.onStartup(context);
	}

	/**
	 * 启用multipart请求,处理文件上传
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {

		// MultipartConfigElement multipartConfigElement = new
		// MultipartConfigElement("/Users/Dragon/Desktop");
		// long maxFileSize单个文件大小,单位:字节 Byte, long maxRequestSize:总文件大小单位:字节,
		// int fileSizeThreshold 0:写入到磁盘
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/Users/Dragon/Desktop", 5097152,
				5097152, 0);
		registration.setMultipartConfig(multipartConfigElement);
	}

	/**
	 * 注册Filter并映射到DispatcherServlet上,源自message源码
	 * 
	 * @return
	 */
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new HiddenHttpMethodFilter(),new DemoFilter() };
	}

	@Override
	protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
		return super.getRootApplicationContextInitializers();
	}

	@Override
	protected void registerContextLoaderListener(ServletContext context) {
		context.addListener(DemoListener.class);
	}

}
