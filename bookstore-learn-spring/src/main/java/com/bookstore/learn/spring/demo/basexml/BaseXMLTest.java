package com.bookstore.learn.spring.demo.basexml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Dragon
 *
 */
public class BaseXMLTest {
	/**
	 * 测试用参数引用
	 */
	@Test
	public void textBaseXMl() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlWithSymbol/basexml.xml");
		CDPlayer cdPlayer = context.getBean(CDPlayer.class);
		cdPlayer.play();
		context.close();
	}
	/**
	 * 测试用参数索引
	 */
	@Test
	public void textBaseXMlIndex() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlWithSymbol/basexmlwithc.xml");
		CDPlayer cdPlayer = context.getBean(CDPlayer.class);
		cdPlayer.play();
		context.close();
	}
	/**
	 * 测试多参数用C标签直接配置
	 */
	@Test
	public void textBaseXMLParamC() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlWithSymbol/ParamsWithc.xml");
		CDPlayer cdPlayer = context.getBean(CDPlayer.class);
		cdPlayer.play();
		context.close();
	}
	/**
	 * 测试多参数用p标签配置属性
	 */
	@Test
	public void textBaseXMLParamP() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlWithSymbol/ParamsWithp.xml");
		CDPlayer cdPlayer = context.getBean(CDPlayer.class);
		cdPlayer.play();
		context.close();
	}
	/**
	 * 测试用util标签配置集合类
	 */
	@Test
	public void textBaseXMLParamUtil() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlWithSymbol/ParamsWithUtil.xml");
		CDPlayer cdPlayer = context.getBean(CDPlayer.class);
		cdPlayer.play();
		context.close();
	}
	

}
