package com.bookstore.learn.spring.demo.javaconfigImportXML;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * 
 * @author Dragon
 *
 */
@Configuration
@ImportResource("classpath:mixConfig/javaMixXML.xml")
public class CDPlayerConfig {

	@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc) {
		return new CDPlayer(compactDisc);
	}

}
