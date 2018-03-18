package com.bookstore.learn.springmvc.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationTest {

	private static AuthenticationManager am = new CustomAuthenticationManager();

	public static void main(String[] args) {
		Authentication request = new UsernamePasswordAuthenticationToken("aaa", "aaa1");
		
		Authentication result = am.authenticate(request);
		
		SecurityContextHolder.getContext().setAuthentication(result);
		
		System.err.println(SecurityContextHolder.getContext().getAuthentication());
	}
}
