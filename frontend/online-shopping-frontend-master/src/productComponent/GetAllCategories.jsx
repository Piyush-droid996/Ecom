import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
// import "./GetAllCategories.css"

const GetAllCategories = () => {
  const [categories, setCategories] = useState([]);

  const retrieveAllCategories = async () => {
    const response = await axios.get(
      "http://localhost:8080/api/product/category/all"
    );
    return response.data;
  };

  useEffect(() => {
    const getAllCategories = async () => {
      const allCategories = await retrieveAllCategories();
      if (allCategories) {
        setCategories(allCategories.categories);
      }
    };

    getAllCategories();
  }, []);

  return (
    <div className="Main">


      <div class="list-group form-card border-color">
        <Link
          to="/home/all/product/categories"
          class="list-group-item list-group-item-action bg-color custom-bg-text"
        >
          <b>All Categories</b>
        </Link>

        {categories.map((category) => {
          return (
            <Link
              to={`/home/product/category/${category.id}/${category.title}`}
              class="list-group-item list-group-item-action text-color custom-bg"
            >
              <b>{category.title}</b>
            </Link>
          );
        })}
      </div>
    </div>
  );
};

export default GetAllCategories;
