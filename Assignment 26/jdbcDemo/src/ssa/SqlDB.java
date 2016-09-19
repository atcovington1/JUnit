package ssa;
import java.sql.*;

public class SqlDB {
	String url = null;
	String usr = null;
	String pwd = null;
	public Connection conn = null;
	
	public int executeSqlUpdate(String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		try {
			int recsAffected = stmt.executeUpdate(sql);
			return recsAffected;
		} catch(SQLException ex) { throw ex; }
	}
	public ResultSet executeSqlQuery(String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch(SQLException ex) { throw ex; }
	}
	public SqlDB(String url, String usr, String pwd) throws SQLException {
		conn = DriverManager.getConnection(url, usr, pwd);
	}
	public void close() throws SQLException {
		if(conn != null) { conn.close(); conn = null; }
	}
}