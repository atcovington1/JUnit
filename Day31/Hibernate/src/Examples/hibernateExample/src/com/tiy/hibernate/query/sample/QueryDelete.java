package com.tiy.hibernate.query.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tiy.entity.Student;

public class QueryDelete {
	
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
			session.delete(student);
			//alternate way to delete data
			session.createQuery("delete Student where id=2").executeUpdate();
			//commiting the transaction
			session.getTransaction().commit();	
			
			
			//
			
		}finally{
			factory.close();
		}
	}
}
