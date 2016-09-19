package org.ssa.tiy.jdbcDemo;

	import java.io.*;
	import java.sql.*;
	import java.util.*;

	public class Assignment24 {
		
		public static Connection myConn=null;
		public static PreparedStatement myStmt=null;
		public static ResultSet myRS=null;
		
		public static void main (String[]args) throws SQLException{
			Connection myConn = null;
			CallableStatement myStmt = null;

		updateData();
		//deleteData();
		//fetchData();
		//insertData();
		}
		
		public static void display() throws SQLException{
			while(myRS.next()){	
				String fName=myRS.getString("first_name");
				String lName=myRS.getString("last_name");
				//double gpa=myRS.getDouble("GPA");
				int sat=myRS.getInt("SAT");
				String major=myRS.getString("description");
				String majorSAT=myRS.getString("req_sat");
				int classname=myRS.getInt("class_id");
		
				//Process the first ResultSet
				System.out.println("Education System - Enrollment Process");
				System.out.println("==================================================");
				System.out.println("                                                      ");
				System.out.println("Enrolled " + fName+" "+ lName+" as a new student.");
				System.out.println( fName+" "+ lName+" has an SAT score of  "+ sat+ ".");
				System.out.println("Assigned "+ fName+" "+ lName+ " to the " + major + "which requires a required SAT score of " + majorSAT+ " ." );
				System.out.println("Enrolled "+ fName+" "+ lName+ " in the following four classes:");
				
				System.out.println( classname +" required for major");
				System.out.println( classname +" required for major");
				System.out.println( classname +" elective (not required for major)");
				System.out.println( classname +" elective (not required for major)");
				display();
				

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
				display();
				
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
				//NEW STUDENT #1
				myStmt.setInt(1, 111 );
				myStmt.setString(2, "Adam");
				myStmt.setString(3, "Zapel");
				myStmt.setInt(4, 1200 );
				myStmt.setDouble(5, 3.0);
				myStmt.setInt(6,  3);
				
				//NEW STUDENT #2
				myStmt.setInt(1, 222 );
				myStmt.setString(2, "Graham");
				myStmt.setString(3, "Krakir");
				myStmt.setInt(4, 500 );
				myStmt.setDouble(5, 2.5);
				myStmt.setInt(6,  7);
				
				//NEW STUDENT #3
				myStmt.setInt(1, 333 );
				myStmt.setString(2, "Ella");
				myStmt.setString(3, "Vader");
				myStmt.setInt(4, 800 );
				myStmt.setDouble(5, 3.0);
				myStmt.setInt(6,  2);
				
				//NEW STUDENT #4
				myStmt.setInt(1, 444 );
				myStmt.setString(2, "Stanley");
				myStmt.setString(3, "Kupp");
				myStmt.setInt(4, 1350);
				myStmt.setDouble(5, 3.3);
				myStmt.setInt(6,  5);
				
				//NEW STUDENT #5
				myStmt.setInt(1, 555 );
				myStmt.setString(2, "Lou");
				myStmt.setString(3, "Zar");
				myStmt.setInt(4, 9500 );
				myStmt.setDouble(5, 3.0);
				myStmt.setInt(6,  6);
				
			int rowAffected=myStmt.executeUpdate();
			System.out.println(rowAffected + "row is Affected");
				
			}catch(Exception ex){
				ex.printStackTrace();
				
			}finally{
				close();
			}
		}

	}

