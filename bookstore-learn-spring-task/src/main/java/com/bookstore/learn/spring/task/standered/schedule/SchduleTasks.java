package com.bookstore.learn.spring.task.standered.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Jul 26, 2017
 * 
 *         <Specification> : Spring Schedule的几种常用注解
 * 
 *         当Spring容器启动后,下面的这些方法都会运行起来,初始化的一些效果可以增加延时或者通过在类初始化的时候增加静态方法打印时间,
 *         在方法执行后打印时间再或者加日志并配置线程名称和执行时间
 * 
 */
@Component
public class SchduleTasks {

	/**
	 * 固定的间隔,考虑执行时间,从本次执行完到下次开始固定间隔的时间,单位是毫秒
	 */
	@Scheduled(fixedDelay = 3000)
	public void sechdulerFixedDelay() {
		System.err.println("this method will be executed each 3 seconds ");
	}

	/**
	 * 固定的频率,不考虑执行时间
	 */
	@Scheduled(fixedRate = 1000)
	public void sechdulerFixedRate() {
		System.err.println("this method will be executed in fix rate (1 second) ");
	}

	/**
	 * 延迟启动,不能单独使用,还是需要配置执行频率或者间隔周期
	 */
	@Scheduled(initialDelay = 10000, fixedDelay = 5000)
	public void sechdulerInitialDelay() {
		System.err.println("this method will be postponed for 10 seconds and executed in fixed delay   ");
	}

	/**
	 * 使用字符串参数配置初始化延时
	 */
	@Scheduled(initialDelayString = "3000")
	public void sechdulerInitialDelayStringDemo() {
		System.err.println("this method will be postponed for 3 seconds and it is configed by String format ");
	}

}
