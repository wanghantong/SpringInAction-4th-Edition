package com.bookstore.learn.spring.demo.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopRun {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xmlWithSymbol/baseaop.xml");

		UserService us = (UserService) ctx.getBean(UserService.class);

		us.printUser();
		
		

	}

}
