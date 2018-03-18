package com.bookstore.learn.spring.demo.annotation;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

public class MyRegistry implements BeanDefinitionRegistry {

	@Override
	public String[] getAliases(String arg0) {
		return null;
	}

	@Override
	public boolean isAlias(String arg0) {
		return false;
	}

	@Override
	public void registerAlias(String arg0, String arg1) {

	}

	@Override
	public void removeAlias(String arg0) {

	}

	@Override
	public boolean containsBeanDefinition(String paramString) {
		return false;
	}

	@Override
	public BeanDefinition getBeanDefinition(String paramString) throws NoSuchBeanDefinitionException {
		return null;
	}

	@Override
	public int getBeanDefinitionCount() {
		return 0;
	}

	@Override
	public String[] getBeanDefinitionNames() {
		return null;
	}

	@Override
	public boolean isBeanNameInUse(String paramString) {
		return false;
	}

	@Override
	public void registerBeanDefinition(String paramString, BeanDefinition paramBeanDefinition)
			throws BeanDefinitionStoreException {

	}

	@Override
	public void removeBeanDefinition(String paramString) throws NoSuchBeanDefinitionException {

	}

}
