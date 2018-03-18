package com.bookstore.learn.spring.demo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestJdkProxy {

	public static void main(String[] args) {

		ICore core = new Core();

		InvocationHandler myJavaHandler = new MyJavaHandler(core);

		ICore newProxyInstance = (ICore) Proxy.newProxyInstance(ICore.class.getClassLoader(),
				core.getClass().getInterfaces(), myJavaHandler);

		newProxyInstance.performTest();

	}
}
