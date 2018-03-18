package com.bookstore.learn.spring.demo.dynamicProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestHandler {
	@Test
	public void testReflect() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = MyReflect.class.getMethods();
		System.out.println("共有  " + methods.length + "  个方法");
		// for (Method me : methods) {
		// System.out.println(me.getName());
		// }
		Method[] declaredMethods = MyReflect.class.getDeclaredMethods();
		System.out.println("共有  " + declaredMethods.length + "  个declaredMethods方法");
		int i = 0;
		for (Method me : declaredMethods) {
			// System.out.println(me.getName());
			i++;
			if (i == 4)
				me.invoke(new MyReflect(), 2);
		}

	}
}
