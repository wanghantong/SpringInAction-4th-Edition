package com.bookstore.learn.spring.task.xml.configuration;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Jul 26, 2017
 * 
 *         <Specification> : 此处为了测试Spring容器的初始化,所以不使用Spring-test,直接使用junit |
 *         main 测试
 * 
 */
public class TestEnviromentInitByXML {

	/**
	 * 通过xml方式初始化Spring容器并加载Bean
	 */
	@Test
	public void testEnviromentInitByXML() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("init/beans.xml");
		XMLBean bean = (XMLBean) context.getBean("xmlBean");
		bean.printClassName();
		context.close();
	}

}
