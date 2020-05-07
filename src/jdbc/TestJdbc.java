package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {

	public static void main(String arg[])
	{
		String JDBCurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String password="Anirudh@tha1";
		try {
			System.out.println("Connecting to Database:"+JDBCurl);
			Connection con = DriverManager.getConnection(JDBCurl,user,password);
			System.out.println("Connection Successful!!!");
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
	}
}
