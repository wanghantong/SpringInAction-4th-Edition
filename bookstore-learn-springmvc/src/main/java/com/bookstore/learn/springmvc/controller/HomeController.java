package com.bookstore.learn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	@RequestMapping(method = { RequestMethod.GET })
	public String home() {
		return "index";
	}
	

	@RequestMapping(value = "/register", method = { RequestMethod.GET })
	public String redirectToRegister() {
		return "register";
	}	
}
