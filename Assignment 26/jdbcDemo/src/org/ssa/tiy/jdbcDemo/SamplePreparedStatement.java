package org.ssa.tiy.jdbcDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class SamplePreparedStatement {
	
	public static Connection myConn=null;
	public static PreparedStatement myStmt=null;
	public static ResultSet myRS=null;
	
	public static void main (String[]args) throws SQLException{
	//updateData();
	//deleteData();
	fetchData();
	//insertData();
	}
	
	public static void display() throws SQLException{
		while(myRS.next()){	
			String fName=myRS.getString("first_name");
			String lName=myRS.getString("last_name");
			double gpa=myRS.getDouble("GPA");
			int sat=myRS.getInt("SAT");
	
			System.out.printf("%s %s %.2f %d", fName, lName, gpa, sat);
			System.out.println();
	
		}	
	}
	private static void fetchData() throws SQLException{
		
		try{
			makeConnection();
			myStmt=(PreparedStatement) myConn.prepareStatement("select * from student where gpa> ? and sat> ?");

			// Set PArameter Values
			myStmt.setDouble(1, 2.0);
			myStmt.setInt(2,  1000);

			//Execute the Query
			myRS= myStmt.executeQuery();

			//Process the first ResultSet
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("First Result Set");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++");
			display();
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Second Result Set");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++");

			myStmt.setDouble(1,  3.0);
			myStmt.setInt(2,  900);
			myRS= myStmt.executeQuery();
			display();

			}catch(Exception ex){
			ex.printStackTrace();
			}finally{
				close();

		}
		
	}
	private static void close() throws SQLException{
		if (myConn!= null)
			myConn.close();
		if(myStmt !=null)
		myStmt.close();
		if(myRS !=null);
		myRS.close();
	}
		
	private static void makeConnection() throws FileNotFoundException, IOException, SQLException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("demo.properties"));
		String dburl= prop.getProperty("dburl");
		String user= prop.getProperty("user");
		String pass= prop.getProperty("password");
		myConn= DriverManager.getConnection(dburl, user, pass);
	}
	private static void deleteData() throws SQLException{
		try{
			makeConnection();
			myStmt=myConn.prepareStatement("delete from student where id=?");
			myStmt.setInt(1, 170);
		int rowAffected=	myStmt.executeUpdate();
		System.out.println(rowAffected + "row is Affected");
			
					
		}catch(Exception ex){
			
		}finally{
			close();
		}

}
	private static void updateData() throws SQLException{
		try{
			makeConnection();
			myStmt=myConn.prepareStatement("update student set SAT=?  where id=?");
			myStmt.setInt(1, 1600 );
			myStmt.setInt(2, 170);
		int rowAffected=myStmt.executeUpdate();
		System.out.println(rowAffected + "row is Affected");
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}finally{
			close();
		}
	}

	private static void insertData() throws SQLException{
		try{
			makeConnection();
			myStmt=myConn.prepareStatement("insert into student values (?,?,?,?,?,?)");
			myStmt.setInt(1, 999 );
			myStmt.setString(2, "Aisha");
			myStmt.setString(3, "Covington");
			myStmt.setInt(4, 999 );
			myStmt.setDouble(5, 3.0);
			myStmt.setInt(6,  1);
			
		int rowAffected=myStmt.executeUpdate();
		System.out.println(rowAffected + "row is Affected");
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}finally{
			close();
		}
	}

}