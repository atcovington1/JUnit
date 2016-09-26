package org.ssa.tiy.createstudent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ssa.tiy.entity.Student;

public class CreateStudent {
	
	public static void main(String[] args) {
	
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	
		Session session=factory.getCurrentSession();
		try{
			Student std1= new Student(1300, "Aisha", "Covington", 4.0, 1);
			Student std2= new Student(860, "Aisha", "Covington",2.5, 2 );
			Student std3= new Student(1340, "Aisha", "Covington", 3.4, 2);
			Student std4= new Student(1260, "Aisha", "Covington", 3.5, 1);
			Student std5= new Student(1600, "Aisha", "Covington", 3.75, 1);
			
			
			
			
			//begin transaction
			
			session.beginTransaction();
		//	session.createQuery("update Student set sat = 1400").executeUpdate();
			
			//session.update(std1);
			session.save(std1);
			session.save(std2);	
			session.save(std3);	
			session.save(std4);
			session.save(std5);
			System.out.println("New Record" + std1);
			System.out.println("New Record2 " + std2);
			System.out.println("New Record 3" + std3);
			System.out.println("New Record4 " + std4);
			System.out.println("New Record5 " + std5);
			
			session.getTransaction().commit(); 
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			factory.close();	
		}
	}

}
