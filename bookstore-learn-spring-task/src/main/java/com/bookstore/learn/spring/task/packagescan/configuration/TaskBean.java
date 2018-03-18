package com.bookstore.learn.spring.task.packagescan.configuration;

import org.springframework.stereotype.Component;

@Component
public class TaskBean {

	public void printClassName() {
		System.out.println("currnet classname is "+this.getClass().getName());
	}

}
