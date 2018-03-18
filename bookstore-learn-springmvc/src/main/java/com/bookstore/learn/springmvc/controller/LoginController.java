package com.bookstore.learn.springmvc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	// @RequestMapping(value = "/login", method = { RequestMethod.GET })
	public Object loginC(HttpServletRequest request) throws ServletException {

		String method = request.getMethod();

//		String username = SSOClient.getLoginName(request);
//
//		System.err.println("username : " + username);

		Cookie[] cookies = request.getCookies();

		StringBuffer requestURL = request.getRequestURL();
		System.err.println("requestURL   :  " + requestURL);

		HttpSession session = request.getSession();
		session.setAttribute("lastvisit", requestURL.toString());
//		session.setAttribute("username", username);

		for (Cookie c : cookies) {
			System.err.println(
					c.getName() + " --   " + c.getValue() + " --   " + c.getMaxAge() + " --   " + c.getSecure());
		}

		System.err.println("this is  login ......" + method);
		// return
		// "redirect:https://sso.test.58.com:8443/gsso/login?service=http%3A%2F%2F127.0.0.1%3A8080%2F";
		return "login";
	}

	// @RequestMapping(value = "/login", method = {
	// RequestMethod.POST,RequestMethod.GET })
	public Object login(HttpServletRequest request) {

		String method = request.getMethod();
		HttpSession session = request.getSession();

		String attribute = (String) session.getAttribute("username");
		System.err.println("session  attribute  " + attribute);

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// StringBuffer requestURL = request.getRequestURL();
		// System.err.println("requestURL : " + requestURL);
		//
		// String requestURI = request.getRequestURI();
		// System.err.println("requestURI : " + requestURI);

		System.err.println("username   : post    : " + username);
		System.err.println("password   : post    : " + password);
		System.err.println("this is  login ......" + method);

		return "forward:/double/parentControl";
	}

//	@RequestMapping(value = "/checkAuthory", method = { RequestMethod.POST, RequestMethod.GET })
	public String checkAuthory(HttpServletRequest request) {

//		try {
//			String username = SSOClient.getLoginName(request);
//			System.err.println("username : " + username);
//			request.login(username, "");
//		} catch (ServletException e) {
//		}
		// Authentication auth = new
		// UsernamePasswordAuthenticationToken(username, "");

		// SpringMVCAuthenticationManager authenticationManager = new
		// SpringMVCAuthenticationManager(null, username);
		//
		// Authentication authentication = new
		// UsernamePasswordAuthenticationToken(username, "");
		// // 将token传递给Authentication进行验证
		// Authentication result =
		// authenticationManager.authenticate(authentication);
		//
		// SecurityContextHolder.getContext().setAuthentication(result);
		
		return "index";

	}

	@ResponseBody
	@RequestMapping(value = "/loginProcess", method = { RequestMethod.POST, RequestMethod.GET })
	public Object loginProcess(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		System.err.println("this is  loginProcess ......");
		return JSON.toJSON(model);
	}

	@ResponseBody
	@RequestMapping(value = "/error", method = { RequestMethod.POST })
	public Object error(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		System.err.println("this is  loginProcess ......");
		return JSON.toJSON(model);
	}
}
