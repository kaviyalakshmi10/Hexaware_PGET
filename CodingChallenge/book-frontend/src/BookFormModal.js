import React, { useState, useEffect } from 'react';
import './BookFormModal.css';

function BookFormModal({ isOpen, onClose, onSubmit, initialData, isEdit }) {
  const [formData, setFormData] = useState({
    isbn: '',
    title: '',
    author: '',
    publicationYear: ''
  });

 
  useEffect(() => {
    if (isOpen) {
      if (isEdit && initialData) {
        setFormData(initialData);
      } else {
        setFormData({
          isbn: '',
          title: '',
          author: '',
          publicationYear: ''
        });
      }
    }
  }, [isOpen, initialData, isEdit]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(formData);
    onClose();
  };

  if (!isOpen) return null;

  return (
    <div className="modal-overlay">
      <div className="modal">
        <h2>{isEdit ? 'Edit Book' : 'Add Book'}</h2>
        <form onSubmit={handleSubmit}>
          {!isEdit && (
            <input
              name="isbn"
              type="text"
              placeholder="ISBN"
              value={formData.isbn}
              onChange={handleChange}
              required
            />
          )}
          <input
            name="title"
            type="text"
            placeholder="Title"
            value={formData.title}
            onChange={handleChange}
            required
          />
          <input
            name="author"
            type="text"
            placeholder="Author"
            value={formData.author}
            onChange={handleChange}
            required
          />
          <input
            name="publicationYear"
            type="number"
            placeholder="Publication Year"
            value={formData.publicationYear}
            onChange={handleChange}
            required
          />

          <div className="modal-buttons">
            <button type="submit" className="add-button">{isEdit ? 'Update' : 'Add'}</button>
            <button type="button" className="cancel-button" onClick={onClose}>Cancel</button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default BookFormModal;
