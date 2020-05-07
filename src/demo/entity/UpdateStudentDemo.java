package demo.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
			//begin transaction
			session.beginTransaction();
			
			//retrieve student from id
			int id = 1;
			Student thisStudent = session.get(Student.class, id);
			
			//update the retrieved student
			thisStudent.setFirstName("Chumma");
			
			//Save student id
			session.getTransaction().commit();
			
			//Restarting session to display table contents
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@email.com'").executeUpdate();
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
