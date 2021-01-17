package com.beer.demo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

public class DBUtil {
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		String username = "root";
		String password = "123456";
    	String dbName="test";
		String driver="com.mysql.jdbc.Driver";
    	String url1="jdbc:mysql://localhost:3306/"+dbName;
    	String url2="?user="+username+"&password="+password;
    	String url3="&useUnicode=true&characterEncoding=UTF-8";
    	String ur1=url1+url2+url3;
    	try {
    		Class.forName(driver);
    		Connection con = (Connection) DriverManager.getConnection(ur1,username,password);
    		return con;
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return null;
	}
	
	public static void main(String args[]) {
		Connection con = DBUtil.getConnection();
		System.out.println(con.toString());
	}
}
