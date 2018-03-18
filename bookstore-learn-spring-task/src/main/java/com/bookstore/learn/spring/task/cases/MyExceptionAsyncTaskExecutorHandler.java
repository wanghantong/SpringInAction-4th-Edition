package com.bookstore.learn.spring.task.cases;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class MyExceptionAsyncTaskExecutorHandler implements AsyncUncaughtExceptionHandler {

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {

		String methodName = method.getName();
		System.err.println(methodName);

		System.err.println(method.getExceptionTypes());
		
		if (ex!=null) {
			System.err.println("11111");
			ex.printStackTrace();
		}
		for (Object obj : params) {
			System.err.println(obj);
		}

	}

}
