package org.bookstore.learn.spring.chapter10.datasource;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourcesConfig.class)
public class DataSourceTest {
	/**
	 * 在测试代码中用System.out.print是很棘手的事情,SystemOutRule类可以基于控制台的输出进行断言
	 */
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Autowired
	C3P0PooledDataSource c3p0DataSource;
	@Autowired
	DruidDataSource druidDataSource;
	@Autowired
	BasicDataSource basicDataSource;
	@Autowired
	DriverManagerDataSource jdbcDataSource;
	@Autowired
	JndiObjectFactoryBean jndiObjectFactoryBean;
	@Autowired
	DataSource dataSource;

	@Test
	public void testC3p0() {
		Class<? extends C3P0PooledDataSource> class1 = c3p0DataSource.getClass();
		System.out.println(class1);
	}

	@Test
	public void testDruid() {
		Class<? extends DruidDataSource> class1 = druidDataSource.getClass();
		System.out.println(class1);
	}

	@Test
	public void testDbcp() {
		Class<? extends BasicDataSource> class1 = basicDataSource.getClass();
		System.out.println(class1);
	}

	@Test
	public void testJdbc() {
		Class<? extends DriverManagerDataSource> class1 = jdbcDataSource.getClass();
		System.out.println(class1);
	}

	@Test
	public void testJndi() {
		Class<? extends JndiObjectFactoryBean> class1 = jndiObjectFactoryBean.getClass();
		System.out.println(class1);
	}

	@Test
	public void testEmbbeded() {
		Class<? extends DataSource> class1 = dataSource.getClass();
		System.out.println(class1);
	}

	
}
