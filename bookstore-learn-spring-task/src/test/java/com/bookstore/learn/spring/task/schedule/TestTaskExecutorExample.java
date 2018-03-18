package com.bookstore.learn.spring.task.schedule;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTaskExecutorExample {

	/**
	 * 基于XML方式加载任务------task/taskxml.xml
	 */
	@Test
	public void testTaskExecutorByXML() {

		// Executor的类型是ThreadPoolTaskExecutor,corePoolSize=5;maxPoolSize=10;queueCapacity=25
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("task/taskxml.xml");
		TaskExecutorExample bean = (TaskExecutorExample) context.getBean("taskExecutorExample");
		bean.printMessages();
		context.close();
	}

	/**
	 * 基于Java配置加载并运行任务
	 */
	@Test
	public void testTaskExecutor() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskConfig.class);
		TaskExecutorJavaConfigExample bean = context.getBean(TaskExecutorJavaConfigExample.class);
		bean.printMessages();
		context.close();
	}

}
