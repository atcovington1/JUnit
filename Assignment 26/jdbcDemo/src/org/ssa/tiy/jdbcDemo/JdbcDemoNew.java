package org.ssa.tiy.jdbcDemo;

import java.sql.*;

public class JdbcDemoNew {
	
	public static Connection myConn= null;
	public static Statement myStmt= null;
	public static ResultSet myRS= null;
	
	public static final String user="root";
	public static final String pass="root";
	public static final String url="jdbc:mysql://localhost:3306/tiy?autoReconnect=true&useSSL=false";
	
	public static void main(String[] args) throws SQLException{
		
		insertData();
		fetchData();
		
	}
	public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException{
		if(myConn!=null)
			myConn.close();
		if(myStmt != null)
			stmt.close();
		if(myRS != null)
			myRS.close();
			
	}
	public static void fetchData() throws SQLException{
		try{
  //1.Get Connection to database
        
        myConn= (Connection)DriverManager.getConnection(url, user, pass);
        
        //2.Create a statement
            myStmt= myConn.createStatement();
            
        //3.Execute SQL query
            
        ResultSet rs= myStmt.executeQuery("select * from student");
        
        //4. Process the result set
        System.out.println("First Name" + "Last Name");
        while(rs.next())
            System.out.println(rs.getString("first_name")+ " \t \t "+ rs.getString("last_name"));
        
        System.out.println("Data Fetched");
    }catch(Exception exc){
        exc.printStackTrace();
        
    }finally{
        
        close(myConn, myStmt, myRS);
        
    }
	}
	
	public static void insertData() throws SQLException{
		
		try{
			
			myConn= DriverManager.getConnection(url, user, pass);
			myStmt= myConn.createStatement();
			
			String sql= "insert student values(200,'George','Washington' ,4.0)";
			
			
		int rowsAffected=	myStmt.executeUpdate(sql);
		
		System.out.println("Rows Affected is: " + rowsAffected);
			
			
		}catch(Exception ex){ 
			ex.printStackTrace();
		}finally{
			if(myConn != null)
				myConn.close();
			if(myStmt !=null)
				myStmt.close();
			
			
		}
		
	}
}
