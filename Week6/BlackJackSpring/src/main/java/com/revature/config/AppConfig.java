package com.revature.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.util.SessionFactoryUtil;

@Configuration
@ComponentScan(value = "com.revature")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {

	private SessionFactoryUtil sessionFactoryUtil;
	
	private static final String DB_NAME = "nick_2005_db";
	
	@Autowired
	public void setSessionFactoryUtil(SessionFactoryUtil sessionFactoryUtil) {
		this.sessionFactoryUtil = sessionFactoryUtil;
	}
	
	@Bean
	public BasicDataSource myDataSource() {
		BasicDataSource data = new BasicDataSource();
		data.setUrl("jdbc:postgresql://" + System.getenv("2005_POSTGRES_URL") + ":5432/" + DB_NAME + "?");
		data.setUsername(System.getenv("2005_POSTGRES_USERNAME"));
		data.setPassword(System.getenv("2005_POSTGRES_PASSWORD"));
		data.setDriver(new org.postgresql.Driver());
		return data;
	}
	
	@Bean
	public SessionFactory mySessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		
		sf.setDataSource(myDataSource());
		sf.setPackagesToScan("com.revature.blackjack.domain");
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.format_sql", "true");
		sf.setHibernateProperties(prop);
		
		return (SessionFactory) sf;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(mySessionFactory());
		
		return tx;
	}
	
	/*
	 * @Bean
	 * 
	 * @Scope("singleton") public SessionFactory sessionFactory() { return
	 * sessionFactoryUtil.getSessionFactory(); }
	 */
	
}
