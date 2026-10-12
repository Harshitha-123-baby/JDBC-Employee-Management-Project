package com.qsp.simple_sms_project.dbconnection;

import java.sql.*;

public class DatabaseConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/sms-db";
	private static String user = "postgres";
	private static String pwd = "tiger";
	
	public static Connection getDBConnection() {
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url,user,pwd);
			return con;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
