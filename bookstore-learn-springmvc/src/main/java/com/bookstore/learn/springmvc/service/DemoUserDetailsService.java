package com.bookstore.learn.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bookstore.learn.springmvc.domain.User;
import com.bookstore.learn.springmvc.repository.UserRepository;

public class DemoUserDetailsService implements UserDetailsService {

	private final UserRepository userRepositoryImpl;
	
	HttpServletRequest request;

	public DemoUserDetailsService(UserRepository userRepositoryImpl,HttpServletRequest request) {
		this.userRepositoryImpl = userRepositoryImpl;
		this.request = request;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.err.println("-loadUserByUsername-----" + username);
		User user = new User();
		user.setUsername(username);
		user.setPassword("123");
		// 查到user
		// User user = userRepositoryImpl.findUserByName(username);

		// 去查user属于哪个用户组

		// 再去查这个用户组有哪些---角色 or 权限

		// 角色可以访问哪些资源 1:N -> 测试组-->ACBD4个资源,adminACBDEF6个资源

		//
		// if (user != null) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority("ADMIN123"));

		// 走的数据库
		// authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		// authorities.add(new SwitchUserGrantedAuthority("ROLE_ADMIN",
		// Authentication));

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);

		// }

		// throw new UsernameNotFoundException("User" + username + "not Found !
		// ");

	}

}
