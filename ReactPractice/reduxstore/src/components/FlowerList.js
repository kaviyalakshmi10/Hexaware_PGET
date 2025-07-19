import ProductCard from "./ProductCard";
import { useDispatch } from "react-redux";
import { addToCart } from "../Redux/CartSlice"; 

const flowers = [
  {
    id: 1,
    name: "Rose",
    price: 50,
    image: "https://source.unsplash.com/200x200/?rose"
  },
  {
    id: 2,
    name: "Tulip",
    price: 40,
    image: "https://source.unsplash.com/200x200/?tulip"
  },
  {
    id: 3,
    name: "Lily",
    price: 60,
    image: "https://source.unsplash.com/200x200/?lily"
  },
  {
    id: 4,
    name: "Daisy",
    price: 30,
    image: "https://source.unsplash.com/200x200/?daisy"
  },
  {
    id: 5,
    name: "Sunflower",
    price: 45,
    image: "https://source.unsplash.com/200x200/?sunflower"
  }
];

const FlowerList = () => {
  const dispatch = useDispatch();

  return (
    <div className="product-container">
      {flowers.map((item) => (
        <ProductCard
          key={item.id}
          name={item.name}
          price={item.price}
          image={item.image}
          onAdd={() => dispatch(addToCart(item))}
        />
      ))}
    </div>
  );
};

export default FlowerList;
