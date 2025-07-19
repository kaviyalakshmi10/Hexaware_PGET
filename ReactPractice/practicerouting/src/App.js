/*import { Route, Routes, Link } from "react-router-dom";
import ShowE from "./ShowE";

import EList from "./EList";*/

import { Link, Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './Home';
import Contact from './Contact';
import Faq from './Faq';
import Login from './Login';
import Welcome from './Welcome';
import ShowU from './ShowU';
import Demo from './Demo';
import { useState } from 'react';
import UCard from './UCard';
import Protected from './Protected';

function App() {
  

  return (
    <div className='cont'>
      
      <table border="2">
        <tr>
          <Link to="/"> <td>Home</td></Link>
          <Link to="/faq"> <td>FAQ</td></Link>
          <Link to="/contact"> <td>Contact</td></Link>
          <Link to="/login"> <td>Login</td></Link>
          <Link to="/demo"> <td>Demo</td></Link>
        </tr>
      </table>

    

      
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/faq" element={<Protected Component={Faq} />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/login" element={<Login />} />
        <Route path="/demo" element={<Demo />} />
        <Route path="/welcome" element={<Welcome />} />
        <Route path="/ucard/:UserId/:Name/:Salary" element={<ShowU />} />
      </Routes>
    </div>
  );
}

/*function App() {
  return (
      <div>
        <nav>
          <Link to="/">Home</Link> | 
          <Link to="/items">Electronic Items</Link>
        </nav>

        <Routes>
          <Route path="/" element={<h2>Welcome Home</h2>} />
          <Route path="/items" element={<EList />} />
          <Route path="/item/:itemCode/:name/:price/:quantity/:city" element={<ShowE />} />
        </Routes>
      </div>
   
  );
}*/

export default App;





