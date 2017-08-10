package com.bookstore.learn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class FowardController {

	@RequestMapping(value = "/forward")
	public String fowardToPage() {
		System.err.println("forward to redirect.jsp");
		return "forward:redirect";
	}

}
