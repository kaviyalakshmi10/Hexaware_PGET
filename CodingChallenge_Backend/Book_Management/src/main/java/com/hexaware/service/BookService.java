package com.hexaware.service;

import com.hexaware.dto.BookDTO;
import com.hexaware.entity.Book;
import com.hexaware.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<BookDTO> getBookByIsbn(String isbn) {
        return bookRepository.findById(isbn)
                .map(this::toDTO);
    }

    public BookDTO addBook(BookDTO bookDTO) {
        Book book = toEntity(bookDTO);
        Book saved = bookRepository.save(book);
        return toDTO(saved);
    }

    public Optional<BookDTO> updateBook(String isbn, BookDTO bookDTO) {
        return bookRepository.findById(isbn).map(existing -> {
            existing.setTitle(bookDTO.getTitle());
            existing.setAuthor(bookDTO.getAuthor());
            existing.setPublicationYear(bookDTO.getPublicationYear());
            Book updated = bookRepository.save(existing);
            return toDTO(updated);
        });
    }

    public void deleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }

    private BookDTO toDTO(Book book) {
        return BookDTO.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publicationYear(book.getPublicationYear())
                .build();
    }

    private Book toEntity(BookDTO dto) {
        return Book.builder()
                .isbn(dto.getIsbn())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .publicationYear(dto.getPublicationYear())
                .build();
    }
}
