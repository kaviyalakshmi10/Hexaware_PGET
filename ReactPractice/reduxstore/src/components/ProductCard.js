const ProductCard = ({ name, price, image, onAdd }) => {
  return (
    <div>
      <img src={image} alt={name} width="100" height="100" />
      <h3>name:{name}</h3>
      <p>price:{price}</p>
      <button onClick={onAdd}>Add to Cart</button>
    </div>
  );
};

export default ProductCard;
