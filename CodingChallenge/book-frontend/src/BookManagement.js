import React, { useState, useEffect, useCallback } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import BookFormModal from './BookFormModal';
import './BookManagement.css';

function BookManagement() {
  const [books, setBooks] = useState([]);
  const [modalOpen, setModalOpen] = useState(false);
  const [selectedBook, setSelectedBook] = useState(null);

  const token = localStorage.getItem('token');
  const navigate = useNavigate();

  useEffect(() => {
    if (!token) {
      navigate('/login');
    }
  }, [token, navigate]);

  const fetchBooks = useCallback(async () => {
    try {
      const response = await axios.get('http://localhost:9020/api/books/all', {
        headers: { Authorization: `Bearer ${token}` },
      });
      setBooks(response.data);
    } catch (error) {
      console.error('Error fetching books:', error);
    }
  }, [token]);

  useEffect(() => {
    fetchBooks();
  }, [fetchBooks]);

  const handleAdd = () => {
    setSelectedBook(null);
    setModalOpen(true);
  };

  const handleEdit = (book) => {
    setSelectedBook(book);
    setModalOpen(true);
  };

  const handleSubmit = async (bookData) => {
    try {
      if (selectedBook) {
        await axios.put(`http://localhost:9020/api/books/${selectedBook.isbn}`, bookData, {
          headers: { Authorization: `Bearer ${token}` },
        });
        alert('Book updated successfully!');
      } else {
        await axios.post('http://localhost:9020/api/books', bookData, {
          headers: { Authorization: `Bearer ${token}` },
        });
        
      }
      fetchBooks();
      setModalOpen(false);
    } catch (error) {
      console.error('Error saving book:', error);
      alert('Failed to save book.');
    }
  };

  const handleDelete = async (isbn) => {
    try {
      await axios.delete(`http://localhost:9020/api/books/${isbn}`, {
        headers: { Authorization: `Bearer ${token}` },
      });
      fetchBooks();
      alert('Book deleted successfully!');
    } catch (error) {
      console.error('Error deleting book:', error);
    }
  };

  const handleLogout = () => {
    localStorage.removeItem('token');
    alert('Logged out successfully!');
    navigate('/login');
  };

  return (
    <div className="book-container">
      <div className="book-header">
        <h1>Book Management System</h1>
        <div>
          <button className="add-button" onClick={handleAdd}>Add New Book</button>
          <button className="logout-button" onClick={handleLogout}>Logout</button>
        </div>
      </div>

      <div className="book-grid">
        {books.map((book) => (
          <div key={book.isbn} className="book-card">
            <h3>{book.title}</h3>
            <p><strong>Author:</strong> {book.author}</p>
            <p><strong>Year:</strong> {book.publicationYear}</p>
            <p><strong>ISBN:</strong> {book.isbn}</p>
            <div className="button-group">
              <button className="edit-button" onClick={() => handleEdit(book)}>Edit</button>
              <button className="delete-button" onClick={() => handleDelete(book.isbn)}>Delete</button>
            </div>
          </div>
        ))}
      </div>

      <BookFormModal
        isOpen={modalOpen}
        onClose={() => setModalOpen(false)}
        onSubmit={handleSubmit}
        initialData={selectedBook}
        isEdit={!!selectedBook}
      />
    </div>
  );
}

export default BookManagement;
