package ssa;

import java.util.List;
import java.io.*;
import java.lang.*;

public class Mainline {

	public static void main(String[] args) {
		try {
			Students students = new Students();
			Student studentEric = students.getById(100);
			System.out.println(student);
			
			studentEric.firstName = "Eric The Red";
			students.update(studentEric);
			studentEric = students.getById(100);
			System.out.println(studentEric);
			
			Student newStudent = new Student();
			newStudent.firstName = "Davey";
			newStudent.lastName = "Jones";
			newStudent.gpa = 3.5;
			newStudent.sat = 1400;
			//students.insert(newStudent);
			
			List<Student> moreStudents = students.getAllStudents();
			for(Student aStudent : moreStudents) {
				System.out.println(aStudent);
			}
			
			students.deleteById(202);
			
			System.out.println("Remaining students");
			List<Student> allStudents = students.getAllStudents();
			for(Student aStudent : allStudents) {
				System.out.println(aStudent);
			}
		} catch (Exception ex) { ex.printStackTrace(); }
	}

}