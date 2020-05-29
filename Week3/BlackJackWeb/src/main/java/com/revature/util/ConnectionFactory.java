package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		if(conn!=null)
		{
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
