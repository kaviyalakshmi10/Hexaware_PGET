import { useLocation } from "react-router-dom";
const Welcome = () => {
      let data=useLocation()
   let {Id,Password}=data.state
  return (
    <>
      <h1> Welcome  {Id}  {Password} </h1>
      
      <h2>Glad to have you here!</h2>
   
    </>
  );
};

export default Welcome;
