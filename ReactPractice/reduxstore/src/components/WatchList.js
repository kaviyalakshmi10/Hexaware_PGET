import ProductCard from "./ProductCard";
import { useDispatch } from "react-redux";
import { addToCart } from "../Redux/CartSlice";

const watches = [
  {
    id: 1,
    name: "Classic Leather Watch",
    price: 1500,
    image: "https://source.unsplash.com/200x200/?leather-watch"
  },
  {
    id: 2,
    name: "Digital Sport Watch",
    price: 900,
    image: "https://source.unsplash.com/200x200/?digital-watch"
  },
  {
    id: 3,
    name: "Luxury Gold Watch",
    price: 3500,
    image: "https://source.unsplash.com/200x200/?gold-watch"
  },
  {
    id: 4,
    name: "Smartwatch",
    price: 2500,
    image: "https://source.unsplash.com/200x200/?smartwatch"
  },
  {
    id: 5,
    name: "Analog Wrist Watch",
    price: 1200,
    image: "https://source.unsplash.com/200x200/?analog-watch"
  }
];

const WatchList = () => {
  const dispatch = useDispatch();

  return (
    <div className="product-container">
      {watches.map((watch) => (
        <ProductCard
          key={watch.id}
          name={watch.name}
          price={watch.price}
          image={watch.image}
          onAdd={() => dispatch(addToCart(watch))}
        />
      ))}
    </div>
  );
};

export default WatchList;
