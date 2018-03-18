package com.bookstore.learn.spring.task.configuration;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.bookstore.learn.spring.task.cases.MyExceptionAsyncTaskExecutorHandler;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Jul 25, 2017
 * 
 *         <Specification> :
 * 
 *         <status> :
 */

@Configuration
@EnableAsync
@ComponentScan(basePackages = { "com.bookstore.learn.spring.task.repository", "com.bookstore.learn.spring.task.service",
		"com.bookstore.learn.spring.task.cases" })
public class MyAsyncConfig implements AsyncConfigurer {

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

		// 线程池的大小是要依赖于执行器的队列容量的
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(10);

		// 执行器的队列容量,这个queue本身是无限长度的,但是如果无限放大,容易引起内存溢出,所以还是得设置,到底多少是合理这个要实际业务测试才知道
		executor.setQueueCapacity(10);
		executor.initialize();
		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new MyExceptionAsyncTaskExecutorHandler();
		// return new MyAsyncUncaughtExceptionHandler();
	}

}
