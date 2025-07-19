import { useDispatch, useSelector } from "react-redux";
import {
  issueBookdsa,
  returnBookdsa,
  issueBookdsaN,
  returnBookdsaN,
  issueBookjava,
  returnBookjava
} from "./BookSlice";

import { useState } from "react";

const Admin = () => {
  const dispatch = useDispatch();
  const { dsa, java } = useSelector((state) => state.book);

  const [dsaQ, setDsaQ] = useState(1);
  const [javaQ, setJavaQ] = useState(1);

  return (
    <>
      <h1>Admin Panel</h1>

      <h2>DSA Books: {dsa}</h2>
      <input
        type="number"
        value={dsaQ}
        onChange={(e) => setDsaQ(Number(e.target.value))}
      />
      <br />
      <button onClick={() => dispatch(issueBookdsa())}>Issue DSA Book</button>
      <button onClick={() => dispatch(returnBookdsa())}>Return DSA Book</button>
      {/* <button onClick={() => dispatch(issueBookdsaN(dsaQ))}>Issue DSA Books</button>
      <button onClick={() => dispatch(returnBookdsaN(dsaQ))}>Return DSA Books</button> */}
 
      <h2>Java Books: {java}</h2>
      <input
        type="number"
        value={javaQ}
        onChange={(e) => setJavaQ(Number(e.target.value))}
      />
      <br />
      <button onClick={() => dispatch(issueBookjava())}>Issue Java Book</button>
      <button onClick={() => dispatch(returnBookjava())}>Return Java Book</button>
    </>
  );
};

export default Admin;
