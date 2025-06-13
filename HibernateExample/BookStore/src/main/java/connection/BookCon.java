package connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Book;

public class BookCon {
	private static SessionFactory  sessionFactory;
	
	    BookCon() {
	    	sessionFactory= new Configuration().configure("book.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();
	        
	    }
	    public static SessionFactory getSessionFactory() {
			BookCon BookCon= new BookCon();
			
			return sessionFactory;
		}

}
