package com.bookstore.learn.spring.demo.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMinstrelMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/minstrel.xml");
		Knight knight = context.getBean(Knight.class);
		
		knight.embarkOnQuest();
		
		context.close();
	}
}
