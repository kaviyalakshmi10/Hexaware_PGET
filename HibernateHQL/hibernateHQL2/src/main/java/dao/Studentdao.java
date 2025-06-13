package dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
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
		    NativeQuery<Student> q=session.createNativeQuery("delete from Student where rollno:rollno",Student.class);
			   q.setParameter("rollno",rno);
			     int r=q.executeUpdate();  
			    if(r>0) {
			    	System.out.println("removed");
			    }
			    else {
			    	System.out.println("not found");
			    }
			txt.commit();
			}
	   
			public void updateData(int rno, String name, double marks) {
			    Session session = factory.openSession();
			    Transaction tx = session.beginTransaction();
			    NativeQuery<Student> q=session.createNativeQuery("update Student set name = :name ,marks=:marks where rollno = :rollno",Student.class);
 
			    q.setParameter("name", name);
			    q.setParameter("marks", marks);
			    q.setParameter("rollno", rno);

			    int u = q.executeUpdate();

			    if (u > 0) {
			        System.out.println("Student updated.");
			    } else {
			        System.out.println("not found.");
			    }

			    tx.commit();
			    session.close();
			    
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
				
				
				NativeQuery<Student> query=session.createNativeQuery("select * from Student", Student.class);
				
				List<Student> usersList=query.list();
				
				
				
				
				
			List<Student> students=	 query.list();
		 
			for(Student s : students )	
			{
				System.out.println(s.toString());
				
			}
			
				
			}
		 
		 



			public void searchHQLName(String snm) {
			    Session session = factory.openSession();

			    Query<Student> query = session.createQuery("from Student where name = :name", Student.class);
			    query.setParameter("name", snm);

			    List<Student> usersList = query.list();
			    for (Student u : usersList) {
			        System.out.println(u.toString());
			    }

			    session.close();
			}
			@Override
			public void serachHQLNameMarks(String name,double marks) {
			
				Session session=factory.openSession();
		 
				
				
				Query <Student>Q=session.createQuery("from Student where name=:name and marks=:marks",Student.class);
				Q.setParameter("name", name);
				Q.setParameter("marks", marks);
		 
				 List<Student> usersList=  Q.list();
				
				 for(Student  u : usersList )
				 {
					 System.out.println(u.toString());
				 }
				
				
				
			}
			public void searchMarksGreaterThan(double Marks) {
			    Session session = factory.openSession();

			    Query<Student> query = session.createQuery(
			        "from Student where marks > :Marks", Student.class);
			    query.setParameter("Marks", Marks);

			    List<Student> students = query.list();

			    students.stream()
			            .forEach(s -> System.out.println(s.toString()));

			    session.close();
			}

			public void removeByRollNo(int rollno)
			{
				Session session=factory.openSession();
				Transaction txTransaction=session.beginTransaction();
				Query <Student>Q=session.createQuery(" delete from Student where rollno=:rollno");
				Q.setParameter("rollno", rollno);
				int r=Q.executeUpdate();
				if(r>0)
				{
					System.out.println("Removed");
				}
				else {
					{
						System.out.println("Not Found");
					}
				}
		 
				
				
			}
			public void updateByRollNo(int rollno, String name) {
			    Session session = factory.openSession();
			    Transaction tx = session.beginTransaction();

			    Query<Student> query = session.createQuery(
			        "update Student set name = :name where rollno = :rollno");
			    query.setParameter("name", name);
			    
			    query.setParameter("rollno", rollno);

			    int r = query.executeUpdate();
			    if (r > 0) {
			        System.out.println("Updated ");
			    } else {
			        System.out.println("Student not found.");
			    }

			    tx.commit();
			    session.close();
			}
			public void ShowDataName() {
				
				
				Session session=factory.openSession();
				
				Query<Student> query=session.createNamedQuery("Student.findAll", Student.class);
				 
				 
				
				List<Student> usersList=query.list();
				
				
				
				
				
			List<Student> students=	 query.list();
		 
			for(Student s : students )	
			{
				System.out.println(s.toString());
				
			}
			
				
			}
			public void removeByRol(int rollno)
			{
				Session session=factory.openSession();
				Transaction txTransaction=session.beginTransaction();
				Query <Student>Q=session.createNamedQuery("Student.removeByRol");
				 
				Q.setParameter("rollno", rollno);
				int r=Q.executeUpdate();
				if(r>0)
				{
					System.out.println("Removed");
				}
				else {
					{
						System.out.println("Not Found");
					}
				}
		 
				
				
			}
			public void searchname(String snm) {
			    Session session = factory.openSession();

			    Query<Student> query = session.createNamedQuery("Student.searchByName",Student.class);
			    query.setParameter("name", snm);

			    List<Student> usersList = query.list();
			    for (Student u : usersList) {
			        System.out.println(u.toString());
			    }

			    session.close();
			}
			

		 
		 
		 
}


	    
