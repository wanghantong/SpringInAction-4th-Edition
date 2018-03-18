///*
// * Copyright 2002-2016 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package com.bookstore.learn.springmvc.configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
//
//import com.bookstore.learn.springmvc.repository.UserRepository;
//import com.bookstore.learn.springmvc.service.DemoUserDetailsService;
//import com.bookstore.learn.springmvc.service.MyFilter;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	HttpServletRequest request;
//
//	@Autowired
//	DataSource dataSource;
//
//	@Autowired
//	UserRepository userRepositoryImpl;
//
//	// @formatter:off
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ADMIN");
//		SimpleGrantedAuthority simpleGrantedAuthority2 = new SimpleGrantedAuthority("qa");
//		List<SimpleGrantedAuthority> list = new ArrayList<>();
//		list.add(simpleGrantedAuthority);
//		list.add(simpleGrantedAuthority2);
//		auth.inMemoryAuthentication()
//			.withUser("user").password("password").roles("USER")
//		.and()
//			.withUser("admin").password("password").authorities(list);
//	}
//	// @formatter:on
//
//	// 2
//	// @formatter:off
//	// JDBC最少配置
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.jdbcAuthentication().dataSource(dataSource);
////	}
//
////	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////		auth.jdbcAuthentication().dataSource(dataSource)
////			//sql写的不对
////			.usersByUsernameQuery("select username,passowrd,enable from User where username = ?")
////			.authoritiesByUsernameQuery("select username, authority from User where username = ?");
////	}
//	// @formatter:on
//
//	// 3
//	// @formatter:off
////	@Autowired
////	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////		auth.jdbcAuthentication().dataSource(dataSource)
////		.usersByUsernameQuery("select username,passowrd,enable from User where username = ?")
////		.authoritiesByUsernameQuery("select username, 'ROLE_USER' from User where username = ?");
////	}
//	// @formatter:on
//
//	// @formatter:off
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
////		.userDetailsService(new DemoUserDetailsService(userRepositoryImpl,request))
////			.addFilterBefore(new MyFilter(), FilterSecurityInterceptor.class)
//		.formLogin()
//		.loginPage("/login")
////			.failureForwardUrl("/error")
////			.loginProcessingUrl("/loginProcess")
//			.permitAll()
////			.rememberMe().tokenValiditySeconds(3600*24).key("bugtrace")
//		.and()
//			.authorizeRequests()
////				.antMatchers("/double/**").hasRole("ADMIN")
//				.antMatchers("/double/**").hasAnyAuthority("ADMIN")
//				.antMatchers(HttpMethod.GET, "/redirect").access("isAuthenticated() and principal.username=='admin'")
//				.antMatchers("/forward").access("isAuthenticated() and hasAnyAuthority('qa')")
//				.antMatchers("/register").hasAnyAuthority("ADMIN")
////				.antMatchers("/").hasRole("ADMIN")
//			.anyRequest().permitAll();
////		http		
////		.addFilterAfter(new MyFilter(), ExceptionTranslationFilter.class);
//		/**
//		 * 
//		 */
////		.and()
////			.requiresChannel().antMatchers("/double/**").requiresSecure();
//		
//	}
//	// @formatter:on
//
//	/**
//	 * 采用UserService实现
//	 */
//	// @Override
//	// protected void configure(AuthenticationManagerBuilder auth) throws
//	// Exception {
//	// // auth.userDetailsService(new
//	// // DemoUserDetailsService(userRepositoryImpl,request));
//	// }
//
//	@Override
//	public void configure(WebSecurity security) throws Exception {
//		security.ignoring().antMatchers("/public/**", "/favicon.ico");
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	}
//
//	// @Override
//	// protected UserDetailsService userDetailsService() {
//	// return super.userDetailsService();
//	// }
//	
//	
//
//}