import { useState } from "react";
import "./App.css";

const Card = ({ id, title, pic, category,price, RemoveData, UpdatePrice }) => {
  const [newPrice, setNewPrice] = useState("");

  return (
    <div className="cont">
      <h1>ID: {id}</h1>
      <h2>Title: {title}</h2>
      <img src={pic} alt={title} width="200" />
      <h3>Category: {category}</h3>
      <p>Price: {price}</p>

      <input
        type="number" placeholder="Enter new price" onChange={(e) => setNewPrice(Number(e.target.value))}
      />
      <div className="button-group">
        <button onClick={() => RemoveData(id)}>Remove</button>
        <button onClick={() => UpdatePrice(id, newPrice)}>Update Price</button>
      </div>
    </div>
  );
};

export default Card;