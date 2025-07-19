import FlowerList from "./components/FlowerList";
import WatchList from "./components/WatchList";
import Billing from "./components/Billing";

import './App.css';

function App() {
  return (
    <div className="App">
      <h1 className="header"> Product Cart App</h1>

      <h2> Flowers</h2>
      <FlowerList />

      <h2> Watches</h2>
      <WatchList />

      <h2> Billing</h2>
      <Billing />
    </div>
  );
}

export default App;
