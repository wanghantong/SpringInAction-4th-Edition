//package com.bookstore.learn.springmvc.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.bookstore.learn.springmvc.domain.User;
//import com.bookstore.learn.springmvc.service.UserService;
//
///**
// * 
// * @author Dragon
// * 
// *         <Date> Jun 28, 2017
// * 
// *         <Specification> : @RequestMapping(value =
// *         "此处设置了路径")时,post,get,URL请求跳转
// * 
// *         <status> : 对应parentControl.jsp,
// */
//@Controller
//@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
//public class SinglePathController {
//
//	@Autowired
//	UserService userServiceImpl;
//
//	/**
//	 * 响应/
//	 * 
//	 * @return
//	 */
//	@RequestMapping(path = "/single1")
//	public String user(HttpServletRequest request) {
//
//		User user = new User();
//		user.setEnabled(true);
//
//		user.setPassword("password");
//		user.setUsername("username");
//
//		userServiceImpl.saveUser(user);
//
//		System.err.println("user saved ...");
//
//		return "single1";
//	}
//
//	@RequestMapping(path = "single2", method = { RequestMethod.GET })
//	public String single2() {
//		return "single2";
//	}
//}
