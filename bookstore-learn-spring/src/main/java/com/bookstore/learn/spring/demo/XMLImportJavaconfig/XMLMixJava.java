package com.bookstore.learn.spring.demo.XMLImportJavaconfig;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Dragon
 *
 */
public class XMLMixJava {
	
	@Test
	public void xmlMixAuto() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mixConfig/xmlMixAuto.xml");
		CDPlayer cdPlayer = context.getBean(CDPlayer.class);
		cdPlayer.play();
		context.close();
	}

}
