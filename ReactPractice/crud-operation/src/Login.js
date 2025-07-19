import { useState } from "react"
 
const Login=()=>
{
 
 
let [Id,setId]=useState()
 
 
let [pass,setPass]=useState()

let [newPass, setNewPass] = useState("");
 
 
 
  const handleUserId=(event)=>
  {
  setId(event.target.value)
  }
 
 
  const handleUserPass=(event)=>
  {
  setPass(event.target.value)
  }
  const handleNewPass=(event) =>{
    setNewPass(event.target.value);


  }
 
 
  const signUp=()=>
  {
    localStorage.setItem(Id,pass)
   
  }

   const signIn=()=>
    {
 
       let p= localStorage.getItem(Id);
       if(p===pass)
       {
        alert("Welcome")
       }
       else{
        alert("Try again")
       }
 

    }
  const updatePassword = () => {
    let up = localStorage.getItem(Id);
    if (up === pass) {
      localStorage.setItem(Id, newPass);

      alert("Password updated successfully!");
    } 
    else {
      alert("password is incorrect!");
    }
  };
  
 
    
 
 
 
return(<>
 
 
<div className="cont">
<input type="text" placeholder="enter user id " onChange={handleUserId}/>
 
 
<input type="password" placeholder="enter Password " onChange={handleUserPass}/>

<input type="password" placeholder="Enter New Password" onChange={handleNewPass} />
 
<button onClick={signIn}> Sign In</button>
<button onClick={signUp}> Sign up</button>
<button onClick={updatePassword}>Update Password</button>
 
 
</div>
 
 
</>)
 
 
}
export default Login
 