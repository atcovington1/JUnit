package org.ssa.tiy.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="SAT")
	private int SAT;                                                                                                                                                                                                                                                         ;
	
	@Column(name="GPA")
	private double GPA;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column (name = "major_id")
	private int major_id;
	
	public Student(){}

	public Student(int SAT, String first_name, String last_name, double GPA, int major_id) {
		this.SAT=SAT;
		this.GPA = GPA;
		this.first_name = first_name;
		this.last_name = last_name;
		this.major_id=major_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGpa(double GPA) {
		this.GPA = GPA;
	}

	public String getfirst_name() {
		return first_name;
	}

	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", SAT=" + SAT + ", GPA=" + GPA + ", first_name=" + first_name + ", last_name="
				+ last_name + ", major_id=" + major_id + "]";
	}
	
}
