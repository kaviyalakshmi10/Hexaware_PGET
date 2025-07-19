import { useNavigate } from "react-router-dom";

const Contact = () => {
    const nav = useNavigate();

  const openSignIn = () => {
    nav("/Login"); 
  };

  return (
    <>
      <h1>Contact</h1>
      <h2>Get in touch with us</h2>
      <p>Email: contact@example.com</p>
      <p>Phone: +91 9876543210</p>

      <button onClick={openSignIn}>Sign In</button>
    </>
  );
};

export default Contact;

