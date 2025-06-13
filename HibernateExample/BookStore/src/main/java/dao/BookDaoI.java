package dao;

import model.Book;

public interface BookDaoI {

	    void addBook(Book book);
	    void updateBookPrice(int bookId, double newPrice);
	    void removeBook(int bookId);
	   
	    void generateBill(int bookId, int quantity);
	    void searchById(int bookId);
	    
	    void listAllBooks();
	


}
