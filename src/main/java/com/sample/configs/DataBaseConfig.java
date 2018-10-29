package com.sample.configs;

import java.net.URISyntaxException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("com.sample.data.repository.jpa ,com.sample.bussiness.service.impl")
@EntityScan("com.sample.base.daos.jpa")
@EnableJpaRepositories(basePackages = { "com.sample.data.repository.jpa" })
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DataBaseConfig {

	public Session session;
	
	@Autowired
	private Environment environment;

	@Bean(destroyMethod = "close", name = "dataSource")
	DataSource dataSource() {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSourceConfig.setJdbcUrl(environment.getProperty("spring.datasource.url"));
		dataSourceConfig.setUsername(environment.getProperty("spring.datasource.username"));
		dataSourceConfig.setPassword(environment.getProperty("spring.datasource.password"));

		return new HikariDataSource(dataSourceConfig);
	}
	
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource());
		sessionBuilder.scanPackages("com.sample.data.repository.jpa");
		return sessionBuilder.buildSessionFactory();
	}
	
	public Session getSession(){
		session = (Session) getSessionFactory();
	    return session;
	  }

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.sample.base.daos.jpa");

		Properties jpaProperties = new Properties();

		// Configures the used database dialect. This allows Hibernate to create SQL
		// that is optimized for the used database.
		jpaProperties.put("hibernate.dialect",
				environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));

		// Specifies the action that is invoked to the database when the Hibernate
		// SessionFactory is created or closed.
		jpaProperties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));

		// Configures the naming strategy that is used when Hibernate creates
		// new database objects and schema elements
		// jpaProperties.put("hibernate.ejb.naming_strategy",
		// environment.getRequiredProperty("hibernate.ejb.naming_strategy"));

		// If the value of this property is true, Hibernate writes all SQL
		// statements to the console.
		jpaProperties.put("hibernate.show_sql", environment.getRequiredProperty("spring.jpa.show-sql"));

		// If the value of this property is true, Hibernate will format the SQL
		// that is written to the console.
		// jpaProperties.put("hibernate.format_sql",
		// environment.getRequiredProperty("hibernate.format_sql"));

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}

	/*
	 * @Bean(name = "transactionManager") public HibernateTransactionManager
	 * getTransactionManager(SessionFactory sessionFactory) {
	 * HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager(sessionFactory); return transactionManager; }
	 */

	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		return initializer;
	}

	/*
	 * Properties getHibernateProperties() { new Properties();
	 * properties.put("schema", environment.getProperty("JNDI.SCHEMA"));
	 * properties.put("hibernate.dialect",
	 * environment.getProperty("HIBERNATE.DIALECT.PGSQL"));
	 * properties.put("hibernate.show_sql",
	 * environment.getProperty("HIBERNATE.SQL.SHOW"));
	 * properties.put("hibernate.format_sql",
	 * environment.getProperty("HIBERNATE.SQL.FORMAT"));
	 * properties.put("hibernate.hbm2ddl.auto",
	 * environment.getProperty("HIBERNATE.HBM2DDL.AUTO"));
	 * properties.put("hibernate.default_schema",
	 * environment.getProperty("JNDI.SCHEMA"));
	 * properties.put("hibernate.use_sql_comments",
	 * environment.getProperty("HIBERNATE.SQL.COMMENTS"));
	 * properties.put("hibernate.connection.CharSet",
	 * environment.getProperty("HIBERNATE.CHARSET"));
	 * properties.put("hibernate.generate_statistics",
	 * environment.getProperty("HIBERNATE.STATISTICS"));
	 * properties.put("hibernate.connection.autocommit",
	 * environment.getProperty("HIBERNATE.AUTOCOMMIT"));
	 * properties.put("hibernate.connection.useUnicode",
	 * environment.getProperty("HIBERNATE.UNICODE"));
	 * properties.put("hibernate.enable_lazy_load_no_trans",
	 * environment.getProperty("HIBERNATE.ENABLED.LAZY"));
	 * properties.put("hibernate.connection.characterEncoding",
	 * environment.getProperty("HIBERNATE.ENCODING")); return properties;
	 * 
	 * }
	 */

}
