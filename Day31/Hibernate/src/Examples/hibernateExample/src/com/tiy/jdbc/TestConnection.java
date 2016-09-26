package com.tiy.jdbc;


import java.sql.*;


public class TestConnection {
	public static void main(String[] args) {
		try{
			String url="jdbc:mysql://localhost:3306/student?useSSL=false";
		
		String user="root";
		String pass="root";
		Connection conn= (Connection) DriverManager.getConnection(url,user,pass);
		System.out.println("cpon success");
	}catch(Exception ex){
		ex.printStackTrace();
		
	}

}

}