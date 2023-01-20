package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutils {

	public static Connection con;
	
	public void OpenConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//reflection
		System.out.println("Driver Loaded....");

		con=DriverManager.getConnection("jdbc:mysql://localhost/dac22","root","root123");
		System.out.println("connected to databases dac22");
	}

	public static Connection getCon() {
		return con;
	}
	
	public void CloseConnection() throws SQLException {
		if(con!=null) {
			con.close();
		}
	}
	
	
	
}
