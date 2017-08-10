package com.bookstore.learn.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class RedirectController {

	@RequestMapping(value = "/redirect", method = { RequestMethod.GET, RequestMethod.POST })
	public String redirectToIndex() {

		System.err.println("redirect to redirectAccept.controller");
		return "redirect:redirectAccept";
	}

	@RequestMapping(value = "/redirectAccept", method = { RequestMethod.GET, RequestMethod.POST })
	public String redirectAccept() {
		System.err.println("get redirect");
		return "redirect";
	}

	@RequestMapping(value = "/redirectWithData", method = { RequestMethod.GET, RequestMethod.POST })
	public String redirectWithData(HttpServletRequest request, HttpServletResponse response, Model model) {

		request.setAttribute("demo", "demo");
		model.addAttribute("model1", "model");
		System.err.println("redirect to redirectWithDataAccept.controller");
		return "redirect:redirectWithDataAccept";
	}

	@RequestMapping(value = "/redirectWithDataAccept", method = { RequestMethod.GET, RequestMethod.POST })
	public String redirectWithDataAccept(HttpServletRequest request, HttpServletResponse response, Model model) {

		System.err.println(request.getAttribute("demo"));
		System.err.println(request.getAttribute("model1"));
		System.err.println(model.containsAttribute("model1"));
		System.err.println("get redirectWithDataAccept");

		return "redirect";
	}

}
