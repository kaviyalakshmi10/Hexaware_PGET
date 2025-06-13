package dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import connection.BookCon;
import model.Book;


public class BookDao implements BookDaoI{

    SessionFactory factory;

    public BookDao() {
        factory = BookCon.getSessionFactory();
    }

    public void addBook(Book b) {
    	
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(b);
        
        tx.commit();
        session.close();
        System.out.println("Book added successfully.");
    }

    public void updateBookPrice(int id, double price) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("update Book set price = :price where bookId = :id");
        
        query.setParameter("price", price);
        query.setParameter("id", id);

        int u = query.executeUpdate();
        if (u > 0) {
            System.out.println("price updated.");
        }
        else {
            System.out.println("book notfound.");
        }

        tx.commit();
        session.close();
    }
    public void removeBook(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("delete from Book where bookId = :id");
        query.setParameter("id", id);

        int u = query.executeUpdate();
        if (u > 0) {
            System.out.println("Removed");
        }
        else {
            System.out.println("not found");
        }

        tx.commit();
        session.close();
    }
 
    public void generateBill(int id, int qty) {
        Session session = factory.openSession();
        
        Book b = session.get(Book.class, id);

        if (b == null) {
            System.out.println("Book not found.");
        }  else {
            double total = b.getPrice() * qty;
            System.out.println("title" + b.getTitle());
            System.out.println("price " + b.getPrice());
            System.out.println("Quantiyt : " + qty);
            System.out.println("total Amt " + total);
        }

        session.close();
    }

    public void searchById(int id) {
        Session session = factory.openSession();
        Book b = session.get(Book.class, id);
        if (b != null) {
            System.out.println(b);
            
        } else {
            System.out.println("Book not found.");
        }
        session.close();
    }

    public void listAllBooks() {
        Session session = factory.openSession();
             Query<Book> query = session.createQuery("from Book", Book.class);
        List<Book> books = query.list();
        for(Book b:books) {
        	System.out.println(b.toString());
        }

     

        session.close();
    }
}
    
    