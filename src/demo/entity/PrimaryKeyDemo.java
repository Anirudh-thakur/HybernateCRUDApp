package demo.entity;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//Creating 3 student objects
			Student[] student = new Student[3];
			student[0] = new Student("Anchit","Thakur","anchit.thakur11@gmail.com");
			student[1] = new Student("Aman","Thakur","aman.thakur11@gmail.com");
			student[2] = new Student("Anshal","Yadav","charchit.thakur11@gmail.com");
					
	        //Starting transaction
			session.beginTransaction();
			
			//saving student objects
			session.save(student[0]);
			session.save(student[1]);
			session.save(student[2]);
			
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}

}
