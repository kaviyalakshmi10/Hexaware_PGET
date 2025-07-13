import React, { useState, useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import axios from 'axios';
import './Login.css';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      navigate('/books');
    }
  }, [navigate]);

  const loginUser = (e) => {
    e.preventDefault();
    const loginData = { username, password };

    axios.post('http://localhost:9020/api/auth/login', loginData)
      .then(response => {
        const token = `${response.data.tokenType} ${response.data.token}`;
        localStorage.setItem('token', token);
        alert('Login successful!');
        navigate('/books');
      })
      .catch(error => {
        console.error('Login error:', error);
        alert('Login failed! Please check your credentials.');
      });
  };

  return (
    <div className="login-container">
      <h1>Book Management System</h1>
      <p>Signin to manage your BookCollections</p>
      <form onSubmit={loginUser}>
        <div className="form-group">
          <label htmlFor="username"> Username</label>
          <input
            type="text"
            id="username"
            placeholder="enter your username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            placeholder="enter your password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="login-button">Login</button>
      </form>
      <p>
        Don't have an account? <Link to="/signup">Register</Link>
      </p>
    </div>
  );
}

export default Login;
