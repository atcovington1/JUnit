package org.ssa.tiy.entity;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	import org.ssa.tiy.entity.Student;

	public class CreateMajor {
		
		public static void main(String[] args) {
		
			SessionFactory factory=new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(major.class)
					.buildSessionFactory();
		
			Session session=factory.getCurrentSession();
			try{
				major major1= new major(15, "Basket Weaving", 1140);
				major major2= new major(16, "American Ninja Chess",1020 );
				major major3= new major(17,"Renaissance Art of the Circle", 820);
				major major4= new major(18, "Don't Delete Me", 600);
				
				session.beginTransaction();	
	session.save(major1);
	session.save(major2);
	session.save(major3);
	session.save(major4);
	
	System.out.println("New Major" + major1);
	System.out.println("New Major" + major2);
	System.out.println("New Major" + major3);
	System.out.println("New Major" + major4);
	
	session.getTransaction().commit(); 

			}catch(Exception ex){
				ex.printStackTrace();
			}
			finally{
				factory.close();	
			}

}
	

		 
		}
