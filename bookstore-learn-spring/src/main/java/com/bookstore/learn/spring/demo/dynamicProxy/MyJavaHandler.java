package com.bookstore.learn.spring.demo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyJavaHandler implements InvocationHandler {

	
	/**
	 * 把真实对象的接口实例注入进来
	 */
	private Object obj;

	public MyJavaHandler() {
	}

	public MyJavaHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		//用的是注入进来的实例
		Object invoke = method.invoke(obj, args);
		System.out.println("after");
		return invoke;
	}

//	public Object bind(Object tar) {
//
//		return null;
//	}

}
