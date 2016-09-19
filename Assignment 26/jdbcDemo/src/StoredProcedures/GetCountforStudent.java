package StoredProcedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class GetCountforStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection myConn = null;
		CallableStatement myStmt = null;

		try {
			// Get a connection to database
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tiy?autoReconnect=true&useSSL=false", "root", "root");

			int theSat = 1000;
			// Prepare the stored procedure call
						myStmt = myConn
								.prepareCall("{call get_count_for_sat(?, ?)}");

						// Set the parameters
						myStmt.setInt(1, theSat);
						myStmt.registerOutParameter(2, Types.INTEGER);
			// Call stored procedure
						System.out.println("Calling stored procedure. get_count_for_sat('  " + "Engineering" + "   ");
						myStmt.execute();	
						System.out.println("Finished calling stored procedure");
						
						
						
						
				} catch (Exception exc) {
					exc.printStackTrace();
				} finally {
					close(myConn, myStmt);
						
	}

}
