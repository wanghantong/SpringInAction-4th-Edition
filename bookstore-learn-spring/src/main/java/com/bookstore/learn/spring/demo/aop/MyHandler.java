package com.bookstore.learn.spring.demo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

	public Object obj;

	public MyHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.err.println("print args : " + args.length);
		if (args.length > 0) {
			for (Object o : args) {
				System.err.println(o.getClass().getTypeName() + " - " + o);
			}
		}

		Object invoke = method.invoke(obj, args);
		System.err.println("done....");

		return invoke;
	}

}
