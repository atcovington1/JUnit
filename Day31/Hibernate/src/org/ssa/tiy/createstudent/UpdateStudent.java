package org.ssa.tiy.createstudent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ssa.tiy.entity.Student;

public class UpdateStudent {
	
	public static void main(String[] args) {
	
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		//create session
		Session session=factory.getCurrentSession();
		try{
			int studentId= 194;
			session.beginTransaction();
		//query student		
		Student student=session.get(Student.class, studentId);
		student.setfirst_name("Peppi");
		
		session.getTransaction().commit();	
			//New code for updating new transaction
				
			session=factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set sat=1400 where id=1 ").executeUpdate();
			
			session.getTransaction().commit();
						
			
			
			
		}finally{
			factory.close();	
		}
	}

}
