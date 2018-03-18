package com.bookstore.learn.spring.task.async.schedule;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
/**
 * 
 * @author Dragon 
 * 
 * <Date>  Jul 26, 2017
 * 
 * <Specification> : @Async异步请求
 * 
 */
@Component
public class TaskSchedulerAsyncXML {
	
	

	// @Scheduled(fixedRate = 2000)
	public void sechdulerFixedRateDemo() {
		System.err.println("------  1  -------");
		testSchedulerAsyncDemo();
		System.err.println("------  3  -------");

	}

	@Async
	public void testSchedulerAsyncDemo() {

		try {
			Thread.sleep(15000);
			System.err.println("---  2  testSchedulerAsyncDemo   sleep 5 seconds....");
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
