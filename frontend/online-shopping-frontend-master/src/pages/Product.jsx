import GetAllCategories from "../productComponent/GetAllCategories";
import CategoryNavigator from "../productComponent/CategoryNavigator";
import { useParams } from "react-router-dom";
import axios from "axios";
import { useEffect, useState } from "react";
import ProductCard from "../productComponent/ProductCard";
import { ToastContainer, toast } from "react-toastify";
import { useNavigate } from "react-router-dom";
import "./Product.css"

// const Product = () => {
//   const { productId, categoryId } = useParams();
//   let navigate = useNavigate();

//   let userToken = sessionStorage.getItem("user-jwtToken");

//   let user = JSON.parse(sessionStorage.getItem("active-user"));

//   const [quantity, setQuantity] = useState("");

//   const [products, setProducts] = useState([]);

//   const [product, setProduct] = useState({
//     id: "",
//     title: "",
//     description: "",
//     quantity: "",
//     price: "",
//     imageName: "",
//     category: { id: "", title: "" },
//   });

//   const retrieveProduct = async () => {
//     const response = await axios.get(
//       "http://localhost:8080/api/product/id?productId=" + productId
//     );

//     return response.data;
//   };

//   useEffect(() => {
//     const getProduct = async () => {
//       const retrievedProduct = await retrieveProduct();

//       setProduct(retrievedProduct.products[0]);
//     };

//     const getProductsByCategory = async () => {
//       const allProducts = await retrieveProductsByCategory();
//       if (allProducts) {
//         setProducts(allProducts.products);
//       }
//     };

//     getProduct();
//     getProductsByCategory();
//   }, [productId]);

//   const retrieveProductsByCategory = async () => {
//     const response = await axios.get(
//       "http://localhost:8080/api/product/category/fetch?categoryId=" +
//       categoryId
//     );
//     console.log(response.data);
//     return response.data;
//   };

//   const saveProductToCart = (userId) => {
//     fetch("http://localhost:8080/api/cart/add", {
//       method: "POST",
//       headers: {
//         Accept: "application/json",
//         "Content-Type": "application/json",
//         Authorization: `Bearer ${userToken}`,
//       },
//       body: JSON.stringify({
//         quantity: quantity,
//         userId: userId,
//         productId: productId,
//       }),
//     })
//       .then((result) => {
//         result.json().then((res) => {
//           if (res.success) {
//             toast.success(res.responseMessage, {
//               position: "top-center",
//               autoClose: 1000,
//               hideProgressBar: false,
//               closeOnClick: true,
//               pauseOnHover: true,
//               draggable: true,
//               progress: undefined,
//             });

//             setTimeout(() => {
//               navigate("/user/mycart");
//             }, 2000); // Redirect after 3 seconds
//           } else if (!res.success) {
//             toast.error(res.responseMessage, {
//               position: "top-center",
//               autoClose: 1000,
//               hideProgressBar: false,
//               closeOnClick: true,
//               pauseOnHover: true,
//               draggable: true,
//               progress: undefined,
//             });
//             setTimeout(() => {
//               window.location.reload(true);
//             }, 2000); // Redirect after 3 seconds
//           } else {
//             toast.error("It Seems Server is down!!!", {
//               position: "top-center",
//               autoClose: 1000,
//               hideProgressBar: false,
//               closeOnClick: true,
//               pauseOnHover: true,
//               draggable: true,
//               progress: undefined,
//             });
//             setTimeout(() => {
//               window.location.reload(true);
//             }, 2000); // Redirect after 3 seconds
//           }
//         });
//       })
//       .catch((error) => {
//         console.error(error);
//         toast.error("It seems server is down", {
//           position: "top-center",
//           autoClose: 1000,
//           hideProgressBar: false,
//           closeOnClick: true,
//           pauseOnHover: true,
//           draggable: true,
//           progress: undefined,
//         });
//         setTimeout(() => {
//           window.location.reload(true);
//         }, 1000); // Redirect after 3 seconds
//       });
//   };

//   const addToCart = (e) => {
//     if (user == null) {
//       alert("Please login as Customer to buy the products!!!");
//       e.preventDefault();
//     } else {
//       saveProductToCart(user.id);
//       setQuantity("");
//       e.preventDefault();
//     }
//   };

//   return (
//     <div className="Main">


//       <div className="container-fluid">
//         <div class="row">
//           <div class="col-sm-2 mt-2">
//             <GetAllCategories />
//           </div>
//           <div class="col-sm-3 mt-2 admin">
//             <div class="card form-card border-color custom-bg">
//               <img
//                 src={
//                   "http://localhost:8080/api/product/image/" + product.imageName
//                 }
//                 style={{
//                   maxHeight: "500px",
//                   maxWidth: "100%",
//                   width: "auto",
//                 }}
//                 class="card-img-top rounded mx-auto d-block m-2"
//                 alt="img"
//               />
//             </div>
//           </div>
//           <div class="col-sm-7 mt-2">
//             <div class="card form-card border-color custom-bg">
//               <div class="card-header bg-color">
//                 <div className="d-flex justify-content-between">
//                   <h1 className="custom-bg-text">{product.title}</h1>
//                 </div>
//               </div>

//               <div class="card-body text-left text-color">
//                 <div class="text-left mt-3">
//                   <h3>Description :</h3>
//                 </div>
//                 <h4 class="card-text">{product.description}</h4>
//               </div>

//               <div class="card-footer custom-bg">
//                 <div className="text-center text-color">
//                   <p>
//                     <span>
//                       <h4>Price : &#8377;{product.price}</h4>
//                     </span>
//                   </p>
//                 </div>
//                 <div className="d-flex justify-content-between">
//                   <div>
//                     <form class="row g-3" onSubmit={addToCart}>
//                       <div class="col-auto">
//                         <input
//                           type="number"
//                           class="form-control"
//                           id="addToCart"
//                           placeholder="Enter Quantity..."
//                           onChange={(e) => setQuantity(e.target.value)}
//                           value={quantity}
//                           required
//                         />
//                       </div>
//                       <div class="col-auto">
//                         <input
//                           type="submit"
//                           className="btn bg-color custom-bg-text mb-3"
//                           value="Add to Cart"
//                         />
//                         <ToastContainer />
//                       </div>
//                     </form>
//                   </div>

//                   <p class="ml-2 text-color">
//                     <b>Stock : {product.quantity}</b>
//                   </p>
//                 </div>
//               </div>
//             </div>
//           </div>
//         </div>

//         <div className="row mt-2">
//           <div className="col-sm-2"></div>

//           <div className="col-sm-10">
//             <h2>Related Products:</h2>
//             <div className="row row-cols-1 row-cols-md-4 g-4">
//               {products.map((product) => {
//                 return <ProductCard item={product} />;
//               })}
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };
const Product = () => {
  const { productId, categoryId } = useParams();
  let navigate = useNavigate();

  let userToken = sessionStorage.getItem("user-jwtToken");
  let user = JSON.parse(sessionStorage.getItem("active-user"));

  const [quantity, setQuantity] = useState("");
  const [products, setProducts] = useState([]);
  const [product, setProduct] = useState({
    id: "",
    title: "",
    description: "",
    quantity: "",
    price: "",
    imageName: "",
    category: { id: "", title: "" },
  });

  const retrieveProduct = async () => {
    const response = await axios.get(
      `http://localhost:8080/api/product/id?productId=${productId}`
    );
    return response.data;
  };

  useEffect(() => {
    const getProduct = async () => {
      const retrievedProduct = await retrieveProduct();
      setProduct(retrievedProduct.products[0]);
    };

    const getProductsByCategory = async () => {
      const allProducts = await retrieveProductsByCategory();
      if (allProducts) {
        setProducts(allProducts.products);
      }
    };

    getProduct();
    getProductsByCategory();
  }, [productId]);

  const retrieveProductsByCategory = async () => {
    const response = await axios.get(
      `http://localhost:8080/api/product/category/fetch?categoryId=${categoryId}`
    );
    return response.data;
  };

  // const saveProductToCart = (userId) => {
  //   fetch("http://localhost:8080/api/cart/add", {
  //     method: "POST",
  //     headers: {
  //       Accept: "application/json",
  //       "Content-Type": "application/json",
  //       Authorization: `Bearer ${userToken}`,
  //     },
  //     body: JSON.stringify({
  //       quantity: quantity,
  //       userId: userId,
  //       productId: productId,
  //     }),
  //   })
  //     .then((result) => {
  //       result.json().then((res) => {
  //         if (res.success) {
  //           toast.success(res.responseMessage, {
  //             position: "top-center",
  //             autoClose: 1000,
  //             hideProgressBar: false,
  //             closeOnClick: true,
  //             pauseOnHover: true,
  //             draggable: true,
  //           });

  //           setTimeout(() => {
  //             navigate("/user/mycart");
  //           }, 2000);
  //         } else {
  //           toast.error(res.responseMessage, {
  //             position: "top-center",
  //             autoClose: 1000,
  //             hideProgressBar: false,
  //             closeOnClick: true,
  //             pauseOnHover: true,
  //             draggable: true,
  //           });
  //         }
  //       });
  //     })
  //     .catch((error) => {
  //       console.error(error);
  //       toast.error("It seems server is down", {
  //         position: "top-center",
  //         autoClose: 1000,
  //         hideProgressBar: false,
  //         closeOnClick: true,
  //         pauseOnHover: true,
  //         draggable: true,
  //       });
  //     });
  // };

  const saveProductToCart = async (userId) => {
    try {
      // Add product to cart
      const cartResponse = await fetch("http://localhost:8080/api/cart/add", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
          Authorization: `Bearer ${userToken}`, // Add Authorization header
        },
        body: JSON.stringify({
          quantity: quantity,
          userId: userId,
          productId: productId,
        }),
      });
 
      const cartResult = await cartResponse.json();
 
      if (!cartResult.success) {
        throw new Error(cartResult.responseMessage || "Failed to add product to cart.");
      }
 
      // Calculate the new stock
      const updatedQuantity = product.quantity - quantity;
 
      // Update stock with PATCH request
      const patchResponse = await axios.patch(
        `http://localhost:8080/api/product/update/${productId}/quantity`,
        { quantity: updatedQuantity }, // Send as JSON body
        {
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
            Authorization: `Bearer ${userToken}`, // Add Authorization header
          },
        }
      );
        // Refresh stock data in the frontend
        setProduct((prevProduct) => ({
          ...prevProduct,
          quantity: updatedQuantity,
        }));
 
        toast.success("Stock updated successfully!", {
          position: "top-center",
          autoClose: 1000,
        });
 
        // Redirect after success
        setTimeout(() => {
          navigate("/user/mycart");
        }, 2000);
     
    } catch (error) {
      console.error("Error occurred:", error.response || error);
 
      // Fallback error message
      const errorMessage = error.response?.data?.message || "Something went wrong with the server.";
 
      toast.error(errorMessage, {
        position: "top-center",
        autoClose: 1000,
      });
    }
  };







  const addToCart = (e) => {
    e.preventDefault();

    if (!user) {
      alert("Please login as Customer to buy the products!");
      return;
    }

    if (quantity <= 0) {
      toast.error("Quantity must be greater than 0!", {
        position: "top-center",
        autoClose: 1000,
      });
      return;
    }

    if (quantity > product.quantity) {
      toast.error(`Only ${product.quantity} items are available in stock!`, {
        position: "top-center",
        autoClose: 1000,
      });
      return;
    }

    saveProductToCart(user.id);
    setQuantity("");
  };

  return (
    <div className="Main">
      <div className="container-fluid">
        <div className="row">
          <div className="col-sm-2 mt-2">
            <GetAllCategories />
          </div>
          <div className="col-sm-3 mt-2 admin">
            <div className="card form-card border-color custom-bg">
              <img
                src={`http://localhost:8080/api/product/image/${product.imageName}`}
                style={{ maxHeight: "500px", maxWidth: "100%", width: "auto" }}
                className="card-img-top rounded mx-auto d-block m-2"
                alt="img"
              />
            </div>
          </div>
          <div className="col-sm-7 mt-2">
            <div className="card form-card border-color custom-bg">
              <div className="card-header bg-color">
                <h1 className="custom-bg-text">{product.title}</h1>
              </div>
              <div className="card-body text-left text-color">
                <h3>Description:</h3>
                <h4>{product.description}</h4>
              </div>
              <div className="card-footer custom-bg">
                <h4>Price: ₹{product.price}</h4>
                <form className="row g-3" onSubmit={addToCart}>
                  <div className="col-auto">
                    <input
                      type="number"
                      className="form-control"
                      placeholder="Enter Quantity..."
                      onChange={(e) => setQuantity(Number(e.target.value))}
                      value={quantity}
                      required
                    />
                  </div>
                  <div className="col-auto">
                    <input
                      type="submit"
                      className="btn bg-color custom-bg-text mb-3"
                      value="Add to Cart"
                    />
                    <ToastContainer />
                  </div>
                </form>
                <p className="ml-2 text-color">
                  <b>Stock: {product.quantity}</b>
                </p>
              </div>
            </div>
          </div>
        </div>

        <div className="row mt-2">
          <div className="col-sm-2"></div>
          <div className="col-sm-10">
            <h2>Related Products:</h2>
            <div className="row row-cols-1 row-cols-md-4 g-4">
              {products.map((product) => (
                <ProductCard item={product} />
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Product;


// export default Product;
