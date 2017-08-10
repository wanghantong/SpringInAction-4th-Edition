package com.bookstore.learn.springmvc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter {

	@Override
	public void destroy() {
		System.err.println("--------  DemoFilter  is  destroyed....");
	}

	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
			FilterChain paramFilterChain) throws IOException, ServletException {
		System.err.println("------- Demo filter is working....");
	}

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
		System.err.println(paramFilterConfig.getFilterName()+" init -------");
	}

}