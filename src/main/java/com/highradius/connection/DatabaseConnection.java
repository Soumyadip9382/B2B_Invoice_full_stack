package com.highradius.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public static Connection getConnection() {
		Connection connection = null;
		String url,user,password;
		url = "jdbc:mysql://localhost:3306/soumyadip";
		user = "root";
		password = "Soumyadip0@";
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	 return connection;
	}

}
