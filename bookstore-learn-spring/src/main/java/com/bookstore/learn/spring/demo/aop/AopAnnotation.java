package com.bookstore.learn.spring.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAnnotation {

	/**
	 * 任意返回值,UserService接口中全部的方法
	 */
	@Pointcut("execution(* com.bookstore.learn.spring.demo.aop.UserService.*(..))")
	public void pointcutName() {
	}

	/**
	 * 任意返回值,UserService接口中全部以get开头的方法
	 */
	@Pointcut("execution(* com.bookstore.learn.spring.demo.aop.UserService.get*(..))")
	public void pointcutName2() {
	}

	/**
	 * aop包内全部的方法
	 */
	@Pointcut("within(com.bookstore.learn.spring.demo.aop.*)")
	public void pointcutName3() {
	}

	/**
	 * aop包及其子包内的全部方法
	 */

	@Pointcut("within(com.bookstore.learn.spring.demo.aop..*)")
	public void pointcutName4() {
	}

	/**
	 * the proxy implements the UserService
	 */
	@Pointcut("this(com.bookstore.learn.spring.demo.aop.UserService)")
	public void pointcutName5() {
	}

	/**
	 * the target object implements the UserService
	 */
	@Pointcut("target(com.bookstore.learn.spring.demo.aop.UserService)")
	public void pointcutName6() {
	}

	// @Pointcut("target(com.bookstore.learn.spring.demo.aop.UserService)")
	public void pointcutName7() {
	}

	@Before("pointcutName6()")
	public void beforeMethod() {
		System.err.println("this is annotation before method");
	}

	@After("pointcutName6()")
	public void afterMethod() {
		System.err.println("this is annotation after method");
	}

	//

	//
	@AfterThrowing("pointcutName6()")
	public void afterThrowingMethod() {
		System.err.println("this is afterThrowing ..  Method ...");
	}

	//
	@AfterReturning("pointcutName6()")
	public void afterReturningMethod() {
		System.err.println("this is after returning ......");
	}

	@Around("pointcutName6()")
	public void aroundMethod(ProceedingJoinPoint jp) {

		System.err.println("around before....");
		Object[] args = jp.getArgs();
		for (Object o : args) {
			System.err.println("参数:    " + o);
		}

		Signature signature = jp.getSignature();
		System.err.println(" target method  signature is  : " + signature);
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.err.println("around after....");

	}
}
