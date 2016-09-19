package StoredProcedures;

import java.sql.*;

/**
 * Test calling stored procedure with INOUT parameters
  */
public class IncreaseGpaForStudents {

	public static void main(String[] args) throws Exception {

		Connection myConn = null;
		CallableStatement myStmt = null;

		try {
			// Get a connection to database
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tiy?autoReconnect=true&useSSL=false", "root", "root");

			int theSat = 1000;
			double theIncreaseAmount = .20;
			
			// Show salaries BEFORE
			System.out.println("Gpa's BEFORE\n");
			showSat(myConn, theSat);

			// Prepare the stored procedure call
			myStmt = myConn
					.prepareCall("{call increase_gpa_for_sat(?, ?)}");

			// Set the parameters
			myStmt.setInt(1, theSat);
			myStmt.setDouble(2, theIncreaseAmount);

			// Call stored procedure
			System.out.println("\n\nCalling stored procedure.  increase_gpa_for_sat('" + theSat + "', " + theIncreaseAmount + ")");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");

			// Show salaries AFTER
			System.out.println("\n\nGPA's AFTER\n");
			showSat(myConn, theSat);

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myConn, myStmt, null);
		}
	}

	private static void showSat(Connection myConn, int theSat) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// Prepare statement
			myStmt = myConn
					.prepareStatement("select * from student where sat > ?");

			myStmt.setInt(1, theSat);
			
			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Process result set
			while (myRs.next()) {
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double gpa = myRs.getDouble("gpa");
				int sat = myRs.getInt("sat");
				
				System.out.printf("%s, %s, %.2f, %d\n", lastName, firstName, gpa, sat);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}

	}

	private static void close(Connection myConn, Statement myStmt,
			ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private static void close(Statement myStmt, ResultSet myRs)
			throws SQLException {

		close(null, myStmt, myRs);
	}
}
