import { useSelector, useDispatch } from "react-redux";
import { removeFromCart, clearCart } from "../Redux/CartSlice";

const Billing = () => {
  const cartItems = useSelector((state) => state.cart.cartItems);
  const dispatch = useDispatch();

  const total = cartItems.reduce(
    (sum, item) => sum + item.price * item.quantity,
    0
  );

  return (
    <div>
      
      {cartItems.length === 0 ? (
        <p>Cart Empty</p>
      ) : (
        <>
          <ul>
            {cartItems.map((item) => (
              <li key={item.id}>
                {item.name} - {item.price} × {item.quantity} = ₹
                {item.price * item.quantity}
                <button onClick={() => dispatch(removeFromCart(item.id))}>
                  remove
                </button>
              </li>
            ))}
          </ul>
          <h3>TotalPrice:{total}</h3>
          <button onClick={() => dispatch(clearCart())}>Clear Cart</button>
        </>
      )}
    </div>
  );
};

export default Billing;
