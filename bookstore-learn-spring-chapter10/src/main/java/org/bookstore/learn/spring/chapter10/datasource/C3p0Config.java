package org.bookstore.learn.spring.chapter10.datasource;

import java.beans.PropertyVetoException;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;

@Configuration
@PropertySource("classpath:/database/mysql.properties")
public class C3p0Config {
	@Autowired
	Environment environment;

	/**
	 * c3p0数据库连接池
	 * 
	 * @throws NamingException
	 * @throws PropertyVetoException
	 */
	@Bean
	public C3P0PooledDataSource c3p0DataSource() throws PropertyVetoException, NamingException {
		C3P0PooledDataSource dataSource = new C3P0PooledDataSource();
		dataSource.setDriverClass(environment.getProperty("driverClass"));
		dataSource.setJdbcUrl(environment.getProperty("jdbcUrl"));
		dataSource.setUser(environment.getProperty("username"));
		dataSource.setPassword(environment.getProperty("password"));
		return dataSource;
	}
}
