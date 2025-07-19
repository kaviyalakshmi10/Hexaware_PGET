const ECard = ({ itemCode, name, price, quantity, city }) => {
  return (
    <div >
      <h3>{itemCode} - {name}</h3>
      <p>Price: {price}</p>
      <p>Quantity: {quantity}</p>
      <p>City: {city}</p>
    </div>
  );
};

export default ECard;

