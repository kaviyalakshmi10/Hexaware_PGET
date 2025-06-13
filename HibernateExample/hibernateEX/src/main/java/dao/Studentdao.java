package dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;


import connection.StudentConn;
import model.Student;

public class Studentdao implements DaoStudentI{
	
SessionFactory factory;
	
	
	public Studentdao() {
	
		factory=StudentConn.getSessionFactory();
	}
 
 

 
	   public void saveData(Student s) {

	        Session session = factory.openSession();
	        Transaction txt = session.beginTransaction();
	        session.save(s);
	        txt.commit();

 
	
	   }
	    public void removeByRoll(int rno) {
			
	        Session session=factory.openSession();
			
			Transaction txt=session.beginTransaction();
			
			Student s= session.get(Student.class, rno);
			
			if(s==null)
			{
				System.out.println("Not Found");
			}
			else 
				{
					session.delete(s);
				}
			txt.commit();
			}
	   
			public void updateData(int rno, String name, double marks) {
			    Session session = factory.openSession();
			    Transaction tx = session.beginTransaction();
			        Student s = session.get(Student.class, rno);
			        if (s == null) {
			            System.out.println("Student not found");
			        } else {
			            s.setName(name);
			            s.setMarks(marks);
			            session.update(s);
			            System.out.println("Student updated successfully.");
			        }
			        tx.commit();
			}
			
			public Student searchByRoll(int rno) {
			    Session session = factory.openSession();
			   
			       Student s = session.get(Student.class, rno);
			        if (s == null) {
			            System.out.println("Student not found ");
			        } else {
			            System.out.println(s);
			        }
			    
			    return s;
			}

			@Override
			public void ShowData() {
				
				
				Session session=factory.openSession();
				 Query<Student> query = session.createQuery("from Student");
				
			List<Student> students=	 query.list();
		 
			for(Student s : students )	
			{
				System.out.println(s.toString());
				
			}
			
				
			}
		 
		 
		 



	    }


