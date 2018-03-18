package com.bookstore.learn.spring.task.classscan.configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Jul 26, 2017
 * 
 *         <Specification> : 此处为了测试Spring容器的初始化,所以不使用Spring-test,直接使用junit |
 *         main 测试
 * 
 *         <status> :
 */
public class TestEnviromentInitByClassScan {

	@Test
	public void enviromentInitTest() {

		// 通过路径扫描的方式加载Spring容器,会按参数路径进行扫描带有@Configuration的类,进行加载
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClassRootConfig.class);
		ClassScan_TaskBean classScan_TaskBean = context.getBean(ClassScan_TaskBean.class);
		classScan_TaskBean.printClassName();
		context.close();
	}

}
