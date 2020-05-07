package demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {
		//Class for reading a student by using id 
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//Create student object
			Student theStudent = new Student("Anirudh","Thakur","anirudh.thakur94@gmail.com");
			
			//begin transaction 
			session.beginTransaction();
			
			//save the current object 
			session.save(theStudent);
			
			//Retrieve student object by using id 
			Student readStudent = session.get(Student.class, theStudent.getId());
			Student readStudent1 = session.get(Student.class, 2);
			
			//Display the student in console after checking if not null
			if(readStudent!=null)
			{
			System.out.println(readStudent);
			}
			else
			{
				System.out.println("Sorry Student not found!");
			}
			if(readStudent1!=null)
			{
				System.out.println(readStudent1);
			}
			else
			{
				System.out.println("Sorry Student not found!");
			}
			
			//Commit the current transaction
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
