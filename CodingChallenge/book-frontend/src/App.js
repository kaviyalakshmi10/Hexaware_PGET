import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './Login';
import SignUp from './SignUp';

import BookManagement from './BookManagement';

import './App.css';
import BookFormModal from './BookFormModal';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/books" element={<BookManagement />} />
        <Route path="/books/add" element={<BookFormModal />} />
        <Route path="/books/:isbn" element={<BookFormModal />} />
      </Routes>
    </Router>
  );
}

export default App;
