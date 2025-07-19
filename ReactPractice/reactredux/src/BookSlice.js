import { createSlice } from "@reduxjs/toolkit";

const bookSlice = createSlice({
  name: 'book',

  initialState: {
    java: 10,
    dsa: 20
  },
  reducers: {
   
    returnBookdsa: (state) => {
      state.dsa += 1;
    },
    issueBookdsa: (state) => {
      state.dsa -= 1;
    },
    returnBookdsaN:(state,action)=>
{
    state.dsa+=action.payload
},
 
issueBookdsaN:(state,action)=>
{
    state.dsa-=action.payload
},

  
    returnBookjava: (state) => {
      state.java += 1;
    },
    issueBookjava: (state) => {
      state.java -= 1;
    }
  }
});

export const { 
  returnBookdsa, 
  issueBookdsa, 
  returnBookjava, 
  issueBookjava,
  returnBookdsaN,
  issueBookdsaN
} = bookSlice.actions;

export default bookSlice.reducer;

