package com.bookstore.learn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * @author Dragon 
 * 
 * <Date>  Jun 28, 2017
 * 
 * <Specification> : @RequestMapping(value = "此处设置了路径")时,post,get,URL请求跳转
 * 
 * <status> : 对应parentControl.jsp,
 */
@Controller
@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
public class SinglePathController {
	
	/**
	 * 响应/
	 * @return
	 */
	@RequestMapping(path = "/single1")
	public String user() {
		return "single1";
	}
	
	@RequestMapping(path="single2",method = { RequestMethod.GET })
	public String single2() {
		return "single2";
	}
}
