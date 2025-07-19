import { Link } from "react-router-dom";
import { useState } from "react";
import ECard from "./ECard.js";

const EList = () => {
  let [items, setItems] = useState([
    { itemCode: 101, name: "Laptop", price: 55000, quantity: 10, city: "Delhi" },
    { itemCode: 102, name: "Smartphone", price: 25000, quantity: 30, city: "Mumbai" },
    { itemCode: 103, name: "Tablet", price: 18000, quantity: 15, city: "Bangalore" },
    { itemCode: 104, name: "Smartwatch", price: 5000, quantity: 25, city: "Hyderabad" },
    { itemCode: 105, name: "Bluetooth Speaker", price: 3000, quantity: 20, city: "Chennai" },
  { itemCode: 106, name: "Wireless Mouse", price: 700, quantity: 40, city: "Pune" },
  { itemCode: 107, name: "Keyboard", price: 1200, quantity: 35, city: "Kolkata" },
  { itemCode: 108, name: "Monitor", price: 9000, quantity: 12, city: "Ahmedabad" },
  { itemCode: 109, name: "Printer", price: 6000, quantity: 8, city: "Jaipur" },
  { itemCode: 110, name: "Router", price: 2500, quantity: 18, city: "Lucknow" },
  { itemCode: 111, name: "Headphones", price: 1500, quantity: 30, city: "Noida" },
  { itemCode: 112, name: "Webcam", price: 2200, quantity: 14, city: "Bhopal" },
  { itemCode: 113, name: "Projector", price: 15000, quantity: 5, city: "Surat" },
  { itemCode: 114, name: "External Hard Drive", price: 4500, quantity: 22, city: "Indore" },
  { itemCode: 115, name: "Power Bank", price: 1000, quantity: 28, city: "Nagpur" },
  { itemCode: 116, name: "Game Console", price: 40000, quantity: 6, city: "Patna" },
  { itemCode: 117, name: "VR Headset", price: 25000, quantity: 4, city: "Kanpur" },
  { itemCode: 118, name: "Digital Camera", price: 32000, quantity: 7, city: "Ranchi" },
  { itemCode: 119, name: "Drone", price: 60000, quantity: 3, city: "Guwahati" },
  { itemCode: 120, name: "E-Reader", price: 8000, quantity: 10, city: "Amritsar" }
  ]);

  return (
    <>
      <h2>Electronic Items</h2>
      {
        items.map((item) => (
          <Link 
            key={item.itemCode}
            to={`/item/${item.itemCode}/${item.name}/${item.price}/${item.quantity}/${item.city}`} 
            
          >
            <ECard {...item} />
          </Link>
        ))
      }
    </>
  );
};

export default EList;
