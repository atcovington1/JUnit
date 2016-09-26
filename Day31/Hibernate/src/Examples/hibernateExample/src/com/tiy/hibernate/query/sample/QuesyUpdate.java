package com.tiy.hibernate.query.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tiy.entity.Student;

public class QuesyUpdate {
	
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new  Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try{
			//
			int studentId=7;
			session.beginTransaction();
			//query student
			Student student=session.get(Student.class, studentId);
			student.setFirstName("Chochit");
			
				session.getTransaction().commit();	
			//New code for updating new trabnsaction
				
			session=factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set sat=1400 where id=1 ").executeUpdate();
			
			session.getTransaction().commit();
			
			//
			
		}finally{
			factory.close();
		}
	}
}
