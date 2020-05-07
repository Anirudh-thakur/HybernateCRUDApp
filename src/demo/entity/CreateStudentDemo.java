package demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		
		try
		{
			//create student object 
			Student newStudent = new Student("Anirudh","Thakur","anirudh.thakur94@gmail.com");
			
			//start transaction 
			session.beginTransaction();
			
			//save student 
			session.save(newStudent);
			
			//commit session
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			factory.close();
		}
	}

}
