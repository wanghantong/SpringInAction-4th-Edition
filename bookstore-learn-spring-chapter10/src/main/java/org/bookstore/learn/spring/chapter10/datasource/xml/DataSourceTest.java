package org.bookstore.learn.spring.chapter10.datasource.xml;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;

public class DataSourceTest {
	/**
	 * 在测试代码中用System.out.print是很棘手的事情,SystemOutRule类可以基于控制台的输出进行断言
	 */
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	/**
	 * 测试连接加载druid数据源
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testDruid() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("datasourceByXml/druid.xml");
		DruidDataSource dataSource = (DruidDataSource) context.getBean("dataSource");
		context.close();
	}

	@Test
	public void testC3p0() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("datasourceByXml/druid.xml");
		C3P0PooledDataSource dataSource = (C3P0PooledDataSource) context.getBean("c3P0PooledDataSource");
		context.close();
	}

	@Test
	public void testDbcp() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("datasourceByXml/druid.xml");
		BasicDataSource dataSource = (BasicDataSource) context.getBean("basicDataSource");
		context.close();
	}

	@Test
	public void testJdbc() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("datasourceByXml/druid.xml");
		DriverManagerDataSource driverManagerDataSource = (DriverManagerDataSource) context
				.getBean("driverManagerDataSource");
		context.close();
	}

}
