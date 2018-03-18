package com.bookstore.learn.spring.task;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskExecutorExampleTest {

	@Test
	public void testTaskExecutor() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("task/taskxml.xml");
		TaskExecutorExample bean = (TaskExecutorExample) context.getBean("taskExecutorExample");
		
		bean.printMessages();
	}
}
