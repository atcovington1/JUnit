package StoredProcedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class GreetTheDepartmentInMajor {

	public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		CallableStatement myStmt = null;

		try {
		// Get a connection to database
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tiy?autoReconnect=true&useSSL=false", "root", "root");
			
			String theDescription = "Engineering";
			
		// Prepare the stored procedure call
			myStmt = myConn
					.prepareCall("{call greet_the_student_in_major(?)}");
	
		// Set the parameters
			
			myStmt.registerOutParameter(1, Types.VARCHAR);
			myStmt.setString(1, theDescription);
			
		// Call stored procedure
				System.out.println("Calling stored procedure greet_the_student_in_major('  " + "Engineering" + "   ')");
				myStmt.execute();	
				System.out.println("Finished calling stored procedure");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close();
		}
	}

}
