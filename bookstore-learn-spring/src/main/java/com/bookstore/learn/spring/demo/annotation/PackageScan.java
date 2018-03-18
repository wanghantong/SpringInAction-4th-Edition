package com.bookstore.learn.spring.demo.annotation;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class PackageScan {
	
	public static void main(String[] args) {
		
		MyRegistry registry = new MyRegistry();
		
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
		Set<BeanDefinition> set = scanner.findCandidateComponents("com.bookstore.learn.spring.demo.autoscan");		
		
	}

}
