package com.tiy.hibernate.query.sample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tiy.entity.Student;

public class QuerySample {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new  Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try{
			//
			session.beginTransaction();
			//query student
			List<Student> students= session.createQuery("from Student").list();
			
			//dispaly student
			display(students);
			
//			students=session.createQuery("from Student s where s.firstName='Amsal'").list();
//			System.out.println("Single Record");
//			displayStudents(students);
//			
			
			session.getTransaction().commit();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			factory.close();
		}

	}

	private static void display(List<Student> students) {
		for(Student std: students)
			System.out.println(std);
	}

	

}
