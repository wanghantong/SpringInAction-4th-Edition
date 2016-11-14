package org.bookstore.learn.spring.chapter10.datasource;

import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.activation.DataSource;
import javax.naming.NamingException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;

@Configuration
@PropertySource("classpath:/database/mysql.properties")
public class DataSourcesConfig {

	@Autowired
	Environment environment;

	/**
	 * Jndi数据源工厂
	 * 
	 * @return error: jndi的名称需要写啥？是干嘛用的,需要查询一下
	 */
	// @Bean
	// public JndiObjectFactoryBean jndiDataSource() {
	// JndiObjectFactoryBean factoryBean = new JndiObjectFactoryBean();
	// factoryBean.setJndiName("jdbc/SpittrDS");// 资源名称
	// factoryBean.setResourceRef(true);
	// factoryBean.setProxyInterface(javax.sql.DataSource.class);
	// return factoryBean;
	// }

	/**
	 * dbcp数据库连接池
	 * 
	 * @return
	 */
	@Bean
	public BasicDataSource dbcpDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("driverClass"));
		dataSource.setUrl(environment.getProperty("jdbcUrl"));
		dataSource.setUsername(environment.getProperty("username"));
		dataSource.setPassword(environment.getProperty("password"));
		return dataSource;
	}

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

	/**
	 * druid数据库连接池 不足:没能配置ProxyFilter,官网推荐xml配置模式
	 * 
	 * @throws SQLException
	 */
	@Bean(initMethod = "init", destroyMethod = "close")
	public DruidDataSource druidDataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(environment.getProperty("driverClass"));
		dataSource.setUrl(environment.getProperty("jdbcUrl"));
		dataSource.setUsername(environment.getProperty("username"));
		dataSource.setPassword(environment.getProperty("password"));
		dataSource.setMaxActive(9);
		dataSource.setQueryTimeout(5);
		dataSource.setFilters("stat");
		return dataSource;
	}

	/**
	 * jdbc数据源
	 * 
	 * @return
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws DataAccessException
	 */
	@Bean
	public DriverManagerDataSource jdbcDataSource() throws SQLException, FileNotFoundException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("driverClass"));
		dataSource.setUrl(environment.getProperty("jdbcUrl"));
		dataSource.setUsername(environment.getProperty("username"));
		dataSource.setPassword(environment.getProperty("password"));
		return dataSource;
	}

	/**
	 * 嵌入式数据源 EmbeddedDatabaseType: H2,derby,HSQL
	 * derby:http://db.apache.org/derby/derby_downloads.html
	 * h2:http://www.h2database.com/html/main.html
	 * HSQL:https://sourceforge.net/projects/hsqldb/files/latest/download?source
	 * =files
	 * 
	 * @return
	 * 
	 * 		error:schema.sql, test-data.sql的格式规范需要查询一下
	 */
	// @Bean
	// public DataSource embeddedDataSource() {
	// return (DataSource) new
	// EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
	// .addScript("classpath:schema.sql").addScript("classpath:test-data.sql").build();
	// }

}
