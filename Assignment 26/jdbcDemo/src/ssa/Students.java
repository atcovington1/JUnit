package ssa;

import java.sql.*;
import java.util.*;

public class Students extends HashMap<Integer, Student> {

	private static final long serialVersionUID = 1L;
	SqlDB db = null;

	public void deleteById(int id) {
		String sql = String.format("DELETE from student where id = %d", id);
		try {
			db.executeSqlUpdate(sql);
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
	public void insert(Student student) {
		String sql = String.format("INSERT student (first_name, last_name, gpa, sat) values ('%s', '%s', %f, %d)",
				student.firstName, student.lastName, student.gpa, student.sat);
		try {
			db.executeSqlUpdate(sql);
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
	public void update(Student student) {
		String sql = String.format("UPDATE student set first_name = '%s', last_name = '%s', gpa = %f, sat = %d where id = %d",
				student.firstName, student.lastName, student.gpa, student.sat, student.id);
		try {
			db.executeSqlUpdate(sql);
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
	public Student getById(int id) {
		List<Student> students = select("SELECT * from student where id = " + id);
		if(students.isEmpty())
			return null;
		return students.get(0);
	}
	public List<Student> getAllStudents() {
		return select("SELECT * from student");
	}
	public List<Student> select(String sql) {
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			ResultSet rs = db.executeSqlQuery(sql);
			while(rs.next()) {
				Student student = loadStudent(rs);
				students.add(student);
			}
			return students;
		} catch (Exception ex) { ex.printStackTrace(); }
		return null;
	}
	public Student createInstance() {
		Student student = new Student();
		return student;
	}
	public Students() {
		super();
		makeSqlConnection();
	}
	private Student loadStudent(ResultSet rs) {
		Student student = new Student();
		try {
			student.id = rs.getInt("id");
			student.firstName = rs.getString("first_name");
			student.lastName = rs.getString("last_name");
			student.gpa = rs.getDouble("gpa");
			student.sat = rs.getInt("sat");
			return student;
		} catch (SQLException ex) { ex.printStackTrace(); }
		return null;
	}
	private void makeSqlConnection() {
		try {
			Properties prop = new Properties();
			prop.load(new java.io.FileInputStream("app.properties"));
			String url = prop.getProperty("url");
			String usr = prop.getProperty("usr");
			String pwd = prop.getProperty("pwd");
			db = new SqlDB(url, usr, pwd);
		} catch (Exception ex) { ex.printStackTrace(); }
	}
}