package com.bookstore.learn.spring.task.async.schedule;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
/**
 * 
 * @author Dragon 
 * 
 * <Date>  Jul 26, 2017
 * 
 * <Specification> : @Async异步请求,使用Java配置
 * 
 */
@Component
public class TaskSchedulerAsyncExample {
	
	/**
	 * 配置TaskExecutor,不再单独写一个ServiceBean去实例化
	 * @return
	 */
	@Bean
	public TaskExecutor createExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(5);
		threadPoolTaskExecutor.setMaxPoolSize(10);
		threadPoolTaskExecutor.setQueueCapacity(25);
		threadPoolTaskExecutor.initialize();
		return threadPoolTaskExecutor;
	}

	/**
	 * 非异步方法中,包含了一个异步方法
	 */
	public void sechdulerFixedRateDemo() {
		System.err.println("------  1  -------");
		testSchedulerAsyncDemo();
		System.err.println("------  3  -------");

	}
	
	/**
	 * 先sleep 15 seconds,再执行,无返回值的异步方法
	 */
	@Async
	public void testSchedulerAsyncDemo() {

		try {
			Thread.sleep(15000);
			System.err.println("---  2  testSchedulerAsyncDemo   sleep 15 seconds....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 使用指定的Executor,在xml中声明的配置
	 */
	@Async("taskExecutor")
	public void testSchedulerAsyncWithAppointExecutorDemo() {

		try {
			Thread.sleep(15000);
			System.err.println("---  2  testSchedulerAsyncDemo   sleep 15 seconds....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 使用指定的Executor,在xml中声明的配置
	 * 
	 * 带有返回值的异步方法(java.util.concurrent.Future +
	 * org.springframework.util.concurrent.ListenableFuture +
	 * java.util.concurrent.CompletableFuture)
	 * 
	 * 
	 * status :doing
	 * 
	 * @return
	 */
	@Async("taskExecutor")
	public Future<?> testSchedulerAsyncWithReturnValueDemo1() {

		try {
			Thread.sleep(15000);
			System.err.println("---  2  testSchedulerAsyncDemo   sleep 5 seconds....");
			AsyncResult<String> asyncResult = new AsyncResult<String>(null);
			return asyncResult;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;


	}
	/**
	 * 使用指定的Executor,在xml中声明的配置
	 * 
	 * 带有返回值的异步方法(java.util.concurrent.Future +
	 * org.springframework.util.concurrent.ListenableFuture +
	 * java.util.concurrent.CompletableFuture)
	 * 
	 * 
	 * status :doing
	 * 
	 * @return
	 */
	@Async("taskExecutor")
	public ListenableFuture<?> testSchedulerAsyncWithReturnValueDemo2() {
		
		try {
			Thread.sleep(15000);
			System.err.println("---  2  testSchedulerAsyncDemo   sleep 5 seconds....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	/**
	 * 使用指定的Executor,在xml中声明的配置
	 * 
	 * 带有返回值的异步方法(java.util.concurrent.Future +
	 * org.springframework.util.concurrent.ListenableFuture +
	 * java.util.concurrent.CompletableFuture)
	 * 
	 * 
	 * status :doing
	 * 
	 * @return
	 */
	@Async("taskExecutor")
	public CompletableFuture<?> testSchedulerAsyncWithReturnValueDemo3() {
		
		try {
			Thread.sleep(15000);
			System.err.println("---  2  testSchedulerAsyncDemo   sleep 5 seconds....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	public void init() {
		System.err.println("------- 1 ---------");
	}

	public void destroy() {
		System.err.println("------- 3 ---------");
	}

}
