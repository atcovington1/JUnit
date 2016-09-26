package com.tiy.hibernate.sample;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tiy.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new  Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try{
			//create student object
//			Student std1= new Student(4.0,1200,"kbye", "hailu");
//			Student std2= new Student(3.0,1200,"amy", "yene");
//			Student std3= new Student(2.0,1200,"kuku", "ehite");
			Student std4= new Student(2.0,1200,"kuku", "ehite");
			Student std6= new Student(4.0,1400,"kuma", "demeksa");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
//			session.save(std1);
//	        session.save(std2);
//			session.save(std3);
			session.save(std6);
//			
//			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
			
			//Retrieving from db using primary key
			// get a new session
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student
			System.out.println("\n Get student by id " + std6.getId());
			Student myStudent= session.get(Student.class,std6.getId());
		
			System.out.println("Student Info" + std6);
			// commit trasaction
		   session.getTransaction().commit();
		
			
		}catch(Exception ex){ex.printStackTrace();}
		finally{
			factory.close();
		}
		
		//

	}

}
