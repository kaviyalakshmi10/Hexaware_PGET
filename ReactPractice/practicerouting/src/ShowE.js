import { useParams } from "react-router-dom";

const ShowE = () => {
  let { itemCode, name, price, quantity, city } = useParams();

  return (
    <div>
      <h1>Item Details</h1>
      <p>Code: {itemCode}</p>
      <p>Name: {name}</p>
      <p>Price: {price}</p>
      <p>Quantity: {quantity}</p>
      <p>City: {city}</p>
    </div>
  );
};

export default ShowE;
