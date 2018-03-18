package com.bookstore.learn.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SpringMVCAuthenticationManager implements AuthenticationManager {

	private UserService userServiceImpl;

	private String username;

	public SpringMVCAuthenticationManager(UserService userServiceImpl, String username) {
		this.userServiceImpl = userServiceImpl;
		this.username = username;
	}

	@Override
	public Authentication authenticate(Authentication paramAuthentication) throws AuthenticationException {

		if (username != "") {
			System.err.println("进行自定义的校验和授权啦.......");
			System.err.println("Credentials    : " + paramAuthentication.getCredentials());
			System.err.println("name   :  " + paramAuthentication.getName());
			// User user = UserServiceImpl.findUser(username);
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

			// 走的数据库
			// authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

			// authorities.add(new SwitchUserGrantedAuthority("ROLE_ADMIN",
			// Authentication));

			if (username.equals("zhaowei17")) {
				authorities.add(new SimpleGrantedAuthority("ADMIN"));
			}

			return new UsernamePasswordAuthenticationToken(paramAuthentication.getName(), "", authorities);
		}

		throw new BadCredentialsException("Bad Credentials");
	}

}
