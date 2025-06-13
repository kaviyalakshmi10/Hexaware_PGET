package com.hexa.hibernate.com.hexa.hibernateExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;

public class App 
{
    
    	SessionFactory  sessionFactory; 
    	
    	Session  session;
    	public App() {
    		
    sessionFactory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        	
        	session=sessionFactory.openSession();
    	}
    	
    	
    	void insert()
    	{
    		
        	Transaction txTransaction= session.beginTransaction();
        	
        	Student s= new Student();
        	s.setRollno(106);
        	s.setName("kany");
        	s.setMarks(10000.0);
        	
        	session.save(s);
        	txTransaction.commit();
    	}
    	
    	void search(int rollno) {
    		session=sessionFactory.openSession();
			Student rs=	session.get(Student.class, rollno);
    	    if(rs!=null)
    	    {
    	    	System.out.println(rs.toString());
    	    }
    	    else {
    	    	System.out.println("Not Found");
    	 
    	    	
    		}
    	}
    	
    	void removeByRollNo(int rno)
    	{
    	
    		session=sessionFactory.openSession();
        	Transaction txTransaction= session.beginTransaction();
        	
        	Student r=session.find(Student.class, rno);
        	
        	if(r==null)
        	{
        		System.out.println("Not Found");
        	}
        	else {
        		
    		
        	session.delete(r);
        		}
        		
        	txTransaction.commit();
     
    	}
    	void updateNameFee(int roll,double marks,String name)
    	{
    		
    		   session=sessionFactory.openSession();  
    		   Transaction txTransaction= session.beginTransaction();  
    		   Student r=session.find(Student.class, roll); 
    		   if(r==null)    {       
    			   System.out.println("Not Found");    } 
    		   else {       
    			   
    			   Student s = new Student();  
    		   s.setRollno(roll);    
    		   s.setName(name);  
    		   s.setMarks(marks);       
    		   session.update(s); 
    		   } 
    		   
    		   txTransaction.commit();
     
        	
    	}
     
     
     
        public static void main( String[] args )
        {
        	
        	
        	
        	
        App obj= new App();
        
        	obj.updateNameFee(101,5000.0, "Ani");
    	
    	
    	
    	
    	
        System.out.println( "Hello World!" );
    }
}
