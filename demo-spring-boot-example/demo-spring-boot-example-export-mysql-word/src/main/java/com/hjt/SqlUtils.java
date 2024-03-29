package com.hjt;

import java.sql.*;

public class SqlUtils {

//	private static String url = "jdbc:mysql://localhost:3306";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnnection(String url, String user,String password){
		try {
			String mysqlUrl = "jdbc:mysql://192.168.20.251:3306/smkj-test-user?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
			return DriverManager.getConnection(mysqlUrl, user, password);
		} catch (SQLException e) {
			System.out.println("Access denied for user (using password: NO)");
			return null;
		}
	}
	
	public static void closeConnection(Connection conn) throws SQLException{
		if(conn!=null){
			conn.close();			
		}
	}
	
	public static ResultSet getResultSet(Connection conn ,String sql){
		try {
			Statement stat = conn.createStatement();
			return stat.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
