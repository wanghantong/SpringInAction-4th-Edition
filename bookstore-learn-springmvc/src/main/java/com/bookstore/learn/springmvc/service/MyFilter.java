package com.bookstore.learn.springmvc.service;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

//@WebFilter
public class MyFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
			FilterChain paramFilterChain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) paramServletRequest;
		HttpServletResponse response = (HttpServletResponse) paramServletResponse;

//		try {
//			String username = SSOClient.getLoginName(request);
//			System.err.println("username : " + username);
//			request.login(username, "");
//		} catch (ServletException e) {
//			e.printStackTrace();
//			System.err.println("登录异常");
//		} catch (Exception e) {
//			System.err.println("未登录");
//		}
		
		paramFilterChain.doFilter(request, response);
	}

}
