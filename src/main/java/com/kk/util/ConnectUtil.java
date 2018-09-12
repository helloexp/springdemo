package com.kk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {
	
	private static String url="jdbc:mysql://localhost:3306/springdemo?" + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
	private static Connection conn;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载数据库驱动");
			try {
				conn =DriverManager.getConnection(url);
				return conn;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
