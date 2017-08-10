package com.bookstore.learn.springmvc.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoServlet implements Servlet{

	@Override
	public void destroy() {
		System.err.println("======= DemoServlet is destroyed........");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig paramServletConfig) throws ServletException {
		System.err.println("======= DemoServlet is init........");
	}

	@Override
	public void service(ServletRequest paramServletRequest, ServletResponse paramServletResponse)
			throws ServletException, IOException {
		
		System.err.println("======= DemoServlet is working.........");
		
	}

}
