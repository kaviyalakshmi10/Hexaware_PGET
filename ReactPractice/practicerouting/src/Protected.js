import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
 
const Protected = (props) => {
  const { Component } = props;
  const navigate = useNavigate();
  const [isAllowed, setIsAllowed] = useState(false);
 
  useEffect(() => {
    const data = localStorage.getItem("data");
 
    if (!data) {
      navigate("/login");
    } else {
      setIsAllowed(true); // Now safe to render the component
    }
  }, [navigate]);
 
  return (
    <>
      {isAllowed && <Component />}
    </>
  );
};
 
export default Protected;
 
 