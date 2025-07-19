import { useParams } from "react-router-dom";
 
const ShowU=()=>
{
 
 
 
    let {UserId,Name,Salary}=useParams()
return(<>
 
 
 
 <h1> {UserId}</h1>
 <h1> {Name}</h1>
 
 
</>)
 
}
export default ShowU;
 