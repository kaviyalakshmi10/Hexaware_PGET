import { useEffect, useState } from "react"
import SCard from "./SCard"
 
const ApiEx = () => {

  // remove ...  id
  let [Products, setProducts] = useState([])
  let [FProducts, setFProducts] = useState([])
  let [search, setSearch] = useState("")

  const handleSearch = (e) => {
    setSearch(e.target.value)
  }

  useEffect(() => {
    fetch("https://dummyjson.com/products")
      .then((res) => res.json())
      .then((temp) => setProducts(temp.products))
      .catch((e) => console.log(e))
  }, [])

  useEffect(() => {
    let data = Products.filter((temp) => temp.category.includes(search))
    setFProducts(data)
  }, [search])

  const RemoveData = (id) => {
    setProducts(Products.filter((temp) => temp.id != id))
  }

  const UpdatePrice = (id, newPrice) => {
    const updatedProducts = Products.map(temp =>
      temp.id === id ? { ...temp, price: newPrice } : temp
    );
    setProducts(updatedProducts);
  };

  return (
    <>
      <input type="text" placeholder="search by..." onChange={handleSearch} />

      {
        search.length
          ? FProducts.map((temp) => (
              <SCard
                id={temp.id}
                title={temp.title}
                pic={temp.thumbnail}
                category={temp.category}
                price={temp.price}
                RemoveData={RemoveData}
                UpdatePrice={UpdatePrice}
              />
            ))
          : Products.map((temp) => (
              <SCard
                id={temp.id}
                title={temp.title}
                pic={temp.thumbnail}
                category={temp.category}
                price={temp.price}
                RemoveData={RemoveData}
                UpdatePrice={UpdatePrice}
              />
            ))
      }

    </>
  );
}

export default ApiEx
