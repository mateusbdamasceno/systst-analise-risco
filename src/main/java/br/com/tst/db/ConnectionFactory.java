package br.com.tst.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/tokyo";
	
	public static Connection createConnectonDb() throws Exception{
		Class.forName("com.jdbc.driver");
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
}
