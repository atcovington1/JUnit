package org.ssa.tiy.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="major")
public class major {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="major_id")
	private int major_id;
	
	@Column(name="minimum_SAT")
	private int minimum_SAT;                                                                                                                                                                                                                                                         ;
	
	@Column(name="major_name")
	private String major_name;
	
		
	public major(){}

	public major(int major_id, String major_name, int minimum_SAT) {
		this.minimum_SAT=minimum_SAT;
		this.major_name = major_name;
		this.major_id=major_id;
	}

	public int getmajor_id() {
		return major_id;
	}

	public void setmajor_id(int major_id) {
		this.major_id = major_id;
	}

	
	public String getmajor_name() {
		return major_name;
	}

	public void setmajor_name(String major_name) {
		this.major_name = major_name;
	}

	public int getminimum_SAT() {
		return minimum_SAT;
	}

	public void setminimum_SAT(int minimun_SAT) {
		this.minimum_SAT = minimun_SAT;
	}

	@Override
	public String toString() {
		return "Major [major_id=" + major_id + ", minimum_SAT=" + minimum_SAT + ", major_name="
				+ major_name + "]";
	}
	
}


