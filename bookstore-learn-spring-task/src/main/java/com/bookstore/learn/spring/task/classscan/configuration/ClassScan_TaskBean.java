package com.bookstore.learn.spring.task.classscan.configuration;

import org.springframework.stereotype.Component;

@Component
public class ClassScan_TaskBean {

	public void printClassName() {
		System.out.println("currnet classname is " + this.getClass().getName());
	}

}
