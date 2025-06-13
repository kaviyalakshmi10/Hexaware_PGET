package com.hexa.hibernate.hiberMap;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
     int bookId;
     String title;

   

    public Book() {
    	
    }



	public Book(int bookId, String title) {
		super();
		this.bookId = bookId;
		this.title = title;
	}



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + "]";
	}
    


}


   