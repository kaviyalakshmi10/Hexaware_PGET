package com.hexa.hibernate.hiberMap;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  SessionFactory sessionFactory= new Configuration().
    			   configure("hMap.cfg.xml").
    			   addAnnotatedClass(Department.class).
    			   addAnnotatedClass(Employee.class).
    			   
    			   
    			   
    			   buildSessionFactory();
    	  
    	  
          Session session = sessionFactory.openSession();
          Transaction tx = session.beginTransaction();

          Department  d= session.get(Department.class, 1);

      System.out.print( d.getdName());
      System.out.print(d.getEmplist());
          
          //Employee e1=new Employee(101,"kan",3000.0);
          //Employee e2=new Employee(102,"kay",7000.0);
          
         // List<Book> list = new ArrayList();
          //list.add(e1);
          //list.add(e2);
          
          //Department ojbD= new Department();
          //ojbD.setdCode(1);
          //ojbD.setdName("Admin");
          //ojbD.setEmplist(list);

          //session.save(ojbD);
         // Book b1 = new Book(101, "Java Programming");
          //Book b2 = new Book(102, "Hibernate In Action");
          //Book b3 = new Book(103, "Spring Framework");
          //List<Book> list = new ArrayList();
          //list.add(b1);
          //list.add(b2);
          //list.add(b3);
          
         // Library lib = new Library();
          //lib.setLibraryId(1);
          //lib.setLibraryName("city library");
          //lib.setBooks(list);
     
          //session.save(lib);
         

          tx.commit();
          
          
    }
    
}
