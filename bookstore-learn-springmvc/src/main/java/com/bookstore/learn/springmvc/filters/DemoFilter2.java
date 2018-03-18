package com.bookstore.learn.springmvc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(filterName = "DemoFilter2", urlPatterns = "*register")
public class DemoFilter2 implements Filter {

	@Override
	public void destroy() {
		System.err.println(this.getClass().getName() + "--------  DemoFilter2  is  destroyed....");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		System.err.println(this.getClass().getName() + "------- Demo filter2 is working....");

		StringBuffer requestURL = request.getRequestURL();
		System.err.println("requestURL  : " +requestURL);
		String requestURI = request.getRequestURI();
		System.err.println("requestURI   : "+requestURI);
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
		System.err.println(this.getClass().getName() + paramFilterConfig.getFilterName() + " init2 -------");
	}

}
