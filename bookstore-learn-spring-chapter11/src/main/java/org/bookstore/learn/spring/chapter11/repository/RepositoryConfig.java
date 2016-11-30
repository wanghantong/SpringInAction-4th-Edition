package org.bookstore.learn.spring.chapter11.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource("classpath:druid.xml")
@ComponentScan
public class RepositoryConfig {

//	@Inject
//	private SessionFactory sessionFactory;
//
//	@Autowired
//	Environment environment;
//
//	@Bean(initMethod = "init", destroyMethod = "close")
//	public DruidDataSource druidDataSource() throws SQLException {
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setDriverClassName(environment.getProperty("driverClass"));
//		dataSource.setUrl(environment.getProperty("jdbcUrl"));
//		dataSource.setUsername(environment.getProperty("username"));
//		dataSource.setPassword(environment.getProperty("password"));
//		dataSource.setMaxActive(9);
//		dataSource.setQueryTimeout(5);
//		dataSource.setFilters("stat");
//		return dataSource;
//	}
//
//	public PlatformTransactionManager annotationDrivenTransactionManager() {
//		System.out.println(sessionFactory);
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//		transactionManager.setSessionFactory(sessionFactory);
//		return transactionManager;
//	}
//	
//	@Bean
//	public SessionFactory sessionFactoryBean() throws SQLException {
//		try {
//			LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
//			lsfb.setDataSource(druidDataSource());
//			lsfb.setPackagesToScan("org.bookstore.*");
//			Properties props = new Properties();
//			props.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
//			lsfb.setHibernateProperties(props);
//			lsfb.afterPropertiesSet();
//			SessionFactory object = lsfb.getObject();
//			return object;
//		} catch (IOException e) {
//			return null;
//		}
//	}
}
