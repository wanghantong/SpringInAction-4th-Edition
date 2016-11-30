package org.bookstore.learn.spring.chapter11;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class LearnSessionFactory {

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		factoryBean.setDataSource(dataSource);
		factoryBean.setMappingResources(new String[]{""});
		
		Properties properties = new Properties();
		properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
		factoryBean.setHibernateProperties(properties);
		
		return factoryBean; 
		
	}
}
