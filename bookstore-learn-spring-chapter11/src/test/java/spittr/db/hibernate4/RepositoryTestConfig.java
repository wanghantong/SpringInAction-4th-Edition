package spittr.db.hibernate4;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan
@PropertySource("classpath:/database/mysql.properties")
@ImportResource("classpath:/spittr/db/hibernate4/RepositoryTest-context.xml")
public class RepositoryTestConfig implements TransactionManagementConfigurer {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	Environment environment;

//	@Bean
//	public DataSource dataSource() {
//		EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
//		edb.setType(EmbeddedDatabaseType.H2);
//		edb.addScript("spittr/db/hibernate4/schema.sql");
//		edb.addScript("spittr/db/hibernate4/test-data.sql");
//		EmbeddedDatabase embeddedDatabase = edb.build();
//		return embeddedDatabase;
//	}
	
//	@Bean(initMethod = "init", destroyMethod = "close")
//	public DruidDataSource druidDataSource() throws SQLException {
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/blog");
//		dataSource.setUsername("root");
//		dataSource.setPassword("dragon");
//		dataSource.setMaxActive(9);
//		dataSource.setQueryTimeout(5);
//		dataSource.setFilters("stat");
//		return dataSource;
//	}

	public PlatformTransactionManager annotationDrivenTransactionManager() {
		System.out.println(sessionFactory);
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

//	@Bean
//	public SessionFactory sessionFactoryBean() throws SQLException {
//		try {
//			LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
//			lsfb.setDataSource(druidDataSource());
//			lsfb.setPackagesToScan("spittr.domain");
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
