package Examples.hibernateExample.src.com.tiy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="saa_employees")
public class Student {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Auto_increament
	@Column(name="id")
	int id;
	
	@Column(name="gpa")
	double gpa;
	
	@Column(name="sat")
	int sat;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;

	public Student(){}

	
	public Student(double gpa, int sat, String firstName, String lastName) {
		this.gpa = gpa;
		this.sat = sat;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public Student(int id,double gpa, int sat, String firstName, String lastName) {
		this.id=id;
		this.gpa = gpa;
		this.sat = sat;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int sat) {
		this.sat = sat;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", gpa=" + gpa + ", sat=" + sat + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
}
