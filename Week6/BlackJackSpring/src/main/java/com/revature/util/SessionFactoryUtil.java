package com.revature.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

//@Component
public class SessionFactoryUtil {
	
	private SessionFactory sf;

	private static String url;

	private static String username;

	private static String password;

	private static final String DB_NAME = "nick_2005_db";

	public SessionFactory getSessionFactory() {
		return this.sf;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}



	public SessionFactoryUtil() {

		if (sf == null) {
			url = System.getenv("2005_POSTGRES_URL");
			url = "jdbc:postgresql://" + url + ":5432/" + DB_NAME + "?";
			username = System.getenv("2005_POSTGRES_USERNAME");
			password = System.getenv("2005_POSTGRES_PASSWORD");
			Map<String, String> settings = new HashMap<String, String>();
			settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
			settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			settings.put("hibernate.connection.url",
					"jdbc:postgresql://" + System.getenv("2005_POSTGRES_URL") + ":5432/" + "nick_2005_db" + "?");
			settings.put("hibernate.connection.username", System.getenv("2005_POSTGRES_USERNAME"));
			settings.put("hibernate.connection.password", System.getenv("2005_POSTGRES_PASSWORD"));

			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().applySettings(settings)
					.build();
			Metadata metadata = new MetadataSources(standardRegistry)
					.addAnnotatedClass(com.revature.blackjack.domain.Card.class)
					.addAnnotatedClass(com.revature.blackjack.domain.CardId.class)
					.addAnnotatedClass(com.revature.blackjack.domain.Player.class)
					.getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
			sf = metadata.getSessionFactoryBuilder().build();
		}

	}

}
