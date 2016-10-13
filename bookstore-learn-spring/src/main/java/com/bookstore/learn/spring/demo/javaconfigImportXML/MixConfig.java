package com.bookstore.learn.spring.demo.javaconfigImportXML;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(CDPlayer.class)
@ImportResource("classpath:mixConfig/javaMixXML.xml")
public class MixConfig {

}
