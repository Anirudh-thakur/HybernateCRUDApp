package demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
         SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
         Session session = factory.getCurrentSession();
         
         try
         {
        	 
        	 session.beginTransaction();
             int id = 1;
            // Student theStudent = session.get(Student.class, id);
            // session.delete(theStudent);
             //session.getTransaction().commit();
            //second approach 
             session.createQuery("delete from Student where id=2").executeUpdate();
             session.getTransaction().commit();
         }
         catch(Exception e)
         {
        	 
         }
         finally
         {
        	 session.close();
         }
	}

}
