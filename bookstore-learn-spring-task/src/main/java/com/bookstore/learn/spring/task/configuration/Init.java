package com.bookstore.learn.spring.task.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bookstore.learn.spring.task.cases.ExceptAsyncTask;

public class Init {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAsyncConfig.class);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		// context.register(MyAsyncConfig.class);
		// context.refresh();

		ExceptAsyncTask bean = context.getBean(ExceptAsyncTask.class);
		bean.goFishing();

	}
}
