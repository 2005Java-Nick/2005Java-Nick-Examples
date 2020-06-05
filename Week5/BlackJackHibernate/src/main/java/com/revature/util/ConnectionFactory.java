package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConnectionFactory {

	private static String url;

	private static String username;

	private static String password;

	private static final String DB_NAME = "nick_2005_db";

	private static ConnectionFactory cf;

	private ConnectionFactory() {
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

		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();
		Metadata metadata = new MetadataSources(standardRegistry)
				.addAnnotatedClass(com.revature.blackjack.domain.Card.class)
				.addAnnotatedClass(com.revature.blackjack.domain.CardId.class).getMetadataBuilder()
				.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
	}

	private Connection createConnection() {
		Connection conn = null;

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}

		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Unable to make connection");
			e.printStackTrace();
		}
		if (conn != null) {
			System.out.println("Working!!");
		}
		return conn;

	}

	public static Connection getConnection() {

		if (cf == null) {
			cf = new ConnectionFactory();
		}

		return cf.createConnection();

	}

}
