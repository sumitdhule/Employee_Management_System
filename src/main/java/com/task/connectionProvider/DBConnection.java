package com.task.connectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private DBConnection() {}
	private static Connection con;
	
	private final static String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final static String DB_USER = "akash";
	private final static String DB_PASS = "0000";
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
	
	
	
}
