package com.bookstore.learn.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public String index(HttpServletRequest request) {
		
//		String user = SSOClient.getLoginName(request);
//		System.err.println(user + " is login !");
//
//		UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(user, user);
//		String username = credentials.getPrincipal().toString();
//		String password = credentials.getCredentials().toString();
//		credentials.eraseCredentials();
		/*
		 * 从数据库中查询user是否存在,如果存在则继续,否则say goodbye
		 */
		// UserPrincipal principal =
		// this.userRepository.getByUsername(username);
		// if (principal == null) {
		// log.warn("Authentication failed for non-existent user {}.",
		// username);
		// return null;
		// }

//		SpringMVCAuthenticationManager authenticationManager = new SpringMVCAuthenticationManager(null, username);
//		//
//		// // 将token传递给Authentication进行验证
//		Authentication authentication = authenticationManager.authenticate(credentials);
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		
//		 List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
//		 System.out.println("当前登录用户的权限的size()  : "+ authorities.size());
//		 
//		 
//		 System.out.println(authorities.get(0).getAuthority());
//		 authorities.forEach(cc -> System.out.println("权限分别是:  "+cc));
		return "index";
	}

	@RequestMapping(method = { RequestMethod.GET })
	public String home(HttpServletRequest request) {
//		index(request);
		return "index";
	}

	@RequestMapping(value = "/register", method = { RequestMethod.GET })
	public String redirectToRegister() {
		return "register";
	}
}
