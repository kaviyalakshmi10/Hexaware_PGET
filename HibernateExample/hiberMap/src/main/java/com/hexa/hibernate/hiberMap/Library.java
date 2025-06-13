package com.hexa.hibernate.hiberMap;

import jakarta.persistence.OneToMany;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Library {

    @Id
     int libraryId;
     String libraryName;
     @OneToMany(targetEntity = Book.class,cascade =CascadeType.ALL)
     List<Book> books;

    public Library() {}

    public Library(int libraryId, String libraryName, List<Book> books) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.books = books;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library [libraryId=" + libraryId + ", libraryName=" + libraryName + "]";
    }
}

