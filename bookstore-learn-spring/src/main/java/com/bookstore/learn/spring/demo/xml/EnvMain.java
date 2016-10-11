package com.bookstore.learn.spring.demo.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class EnvMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.getEnvironment().setActiveProfiles("macMysql");
		// context.getEnvironment().setActiveProfiles("winMysql");
		context.load("spring/environment.xml");
		context.refresh();
		Knight knight = context.getBean(Knight.class);
		knight.embarkOnQuest();
		context.close();

	}
}
