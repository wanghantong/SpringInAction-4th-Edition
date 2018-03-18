package spittr.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:/database/mysql.properties")
public class DataConfig {
	@Autowired
	Environment environment;

	// @Bean
	// public DataSource dataSource() {
	// return new EmbeddedDatabaseBuilder()
	// .setType(EmbeddedDatabaseType.H2)
	// .addScript("schema.sql")
	// .build();
	// }
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

	@Bean
	public JdbcOperations jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
