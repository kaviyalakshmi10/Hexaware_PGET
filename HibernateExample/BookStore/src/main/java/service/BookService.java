package service;

import java.util.Scanner;

import dao.BookDao;
import model.Book;


public class BookService {
	Book b;

    Scanner sc;
    BookDao dao;

    public BookService() {
    	b=new Book();
    
        sc = new Scanner(System.in);
        dao = new BookDao();
    }
    
    public void addBookSer() {
        System.out.print("Enter bookid: ");
        b.setBookId(sc.nextInt());
        sc.nextLine(); 

        System.out.print("enter book title: ");
        b.setTitle(sc.nextLine());

        System.out.print("enter book author ");
        b.setAuthor(sc.nextLine());

        System.out.print("enter book price: ");
        b.setPrice(sc.nextDouble());

        System.out.print("enter book Quantity: ");
        b.setQuantity(sc.nextInt());

        dao.addBook(b);
    }


    public void updateBookPriceSer() {
        System.out.print("enter book id: ");
        int id = sc.nextInt();

        System.out.print("enter new Price: ");
        double price = sc.nextDouble();

        dao.updateBookPrice(id, price);
    }

   
    public void removeBookSer() {
        System.out.print("enter bookid to remoce: ");
        int id = sc.nextInt();
        dao.removeBook(id);
    }

 
    public void generateBillSer() {
        System.out.print("enter bookid: ");
        int id = sc.nextInt();
        System.out.print("quantity: ");
        int qty = sc.nextInt();

        dao.generateBill(id, qty);
    }


    public void enquiryByIdSer() {
        System.out.print("enter bookid ");
        int id = sc.nextInt();
        dao.searchById(id);
    }
    public void showAllBooks() {
        dao.listAllBooks();
    }
}

