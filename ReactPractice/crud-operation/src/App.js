import { useState } from "react";
import Morning from "./Morning";
import Night from "./Night";

 
const App=()=>
{
 
 
    let [time,setTime]=useState(0);
   //let [Flag,SetFlag]=useState(0)
 
    const handleTime=(e)=>
 
        {
               setTime(e.target.value)
    }
 
return(<>
 
 
<input type="text" placeholder="enter time" onChange={handleTime}/>
 

 
{time && (time <= 12 ? <Morning /> : <Night />)}

 
 
</>)

 
 
 
}


export default App;
 