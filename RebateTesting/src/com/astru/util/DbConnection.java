package com.astru.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String DB_CONNECTION = "jdbc:oracle:thin:@61.247.230.168:1521:rc";
	
	private static String DB_USER = "hr";
	private static String DB_PASSWORD = "hr";
	public static Connection con=null;
	
	public static Connection getConnection(){
		
		try {

			Class.forName(DB_DRIVER);
			con=DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
		
		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		
		return con;
	}

}
