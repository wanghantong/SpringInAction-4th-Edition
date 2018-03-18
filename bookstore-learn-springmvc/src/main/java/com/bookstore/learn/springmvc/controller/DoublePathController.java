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
@RequestMapping(value = "double", method = { RequestMethod.GET, RequestMethod.POST })
public class DoublePathController {
	
	/**
	 * 响应/add/parentControl
	 * @return
	 */
	@RequestMapping(path = "parentControl")
	public String user() {
		return "parentControl";
	}
	@RequestMapping(path = "secondLevel")
	public String secondLevel() {
		return "secondLevel";
	}
}
