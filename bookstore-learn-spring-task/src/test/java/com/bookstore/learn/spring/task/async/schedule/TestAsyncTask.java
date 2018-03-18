package com.bookstore.learn.spring.task.async.schedule;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAsyncTask {

	/**
	 * 执行一个包含了异步方法的同步方法,类之间的方法调用是无法使异步生效的,很多人会踩坑
	 */
	@Test
	public void testAsyncTask1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncConfig.class);
		TaskSchedulerAsyncExample bean = context.getBean(TaskSchedulerAsyncExample.class);
		// 此时方法体内的方法变成了同步了,会顺序执行
		bean.sechdulerFixedRateDemo();
		context.close();
	}

	/**
	 * 此时异步方法会异步执行,我们可以看到执行完1，3就立即执行,然后后就停止了,1-3执行是正确的,看不到2的原因是Junit采用的是守护线程,
	 * 主线程停止后守护线程也停止了,换成非守护线程即可看到效果---参考main函数
	 */
	@Test
	public void testAsyncTask2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncConfig.class);
		TaskSchedulerAsyncExample bean = context.getBean(TaskSchedulerAsyncExample.class);
		bean.init();// 1
		bean.testSchedulerAsyncDemo();// 2
		bean.destroy();// 3
		context.close();
	}

	/**
	 * main函数为非守护线程,所以此时能够看到异步执行的效果
	 * 
	 * 打印结果 1 3 2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncConfig.class);
		TaskSchedulerAsyncExample bean = context.getBean(TaskSchedulerAsyncExample.class);
		bean.init();// 1
		bean.testSchedulerAsyncDemo();// 2
		bean.destroy();// 3
		context.close();
	}

}
