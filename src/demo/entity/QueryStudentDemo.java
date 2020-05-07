package demo.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {
	
	@SuppressWarnings("unchecked")
	public static void main(String arg[])
	{
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
		    // Start transaction
			session.beginTransaction();
			
			//Add query results to list 
			//All students
			List<Student> AllStudents = session.createQuery("from Student").getResultList();
			//specific students
			List<Student> SomeStudents = session.createQuery("from Student s where s.lastName='Thakur'").getResultList();
			//specific strudents by using "OR" predicate
			List<Student> SomeStudents1 = session.createQuery("from Student s where s.lastName='Thakur' OR s.firstName='Anshal'").getResultList();		
			//spectific students by using like predicate
			List<Student> SomeStudents2 = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			//print list by using a seperate print function
			System.out.println("All Students..");
			PrintStudentList(AllStudents);
			System.out.println("Students with last name Thakur..");
			PrintStudentList(SomeStudents);
			System.out.println("Students with last name thakur or first name Anshal ..");
			PrintStudentList(SomeStudents1);
			System.out.println("Student with gmail addresses..");
			PrintStudentList(SomeStudents2);
			
			
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

	private static void PrintStudentList(List<Student> Students) {
		// TODO Auto-generated method stub
		for(Student student:Students)
		{
			System.out.println(student);
		}
	}
	}

