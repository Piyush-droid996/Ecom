import carousel1 from "../images/carousel_1.jpg";
import carousel2 from "../images/carousel_2.jpg";
import carousel3 from "../images/carouse_3.jpg";
import "./Carousel.css";

const Carousel = () => {
  return (
    <div className="Main">
      <div
        id="carouselExampleCaptions"
        className="carousel slide"
        data-bs-ride="carousel"
      >
        <div className="carousel-indicators">
          <button
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide-to="0"
            className="active"
            aria-current="true"
            aria-label="Slide 1"
          ></button>
          <button
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide-to="1"
            aria-label="Slide 2"
          ></button>
          <button
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide-to="2"
            aria-label="Slide 3"
          ></button>
        </div>
        <div className="carousel-inner">
          <div className="carousel-item active">
            <img
              src={carousel1}
              className="d-block w-100 carousel-image"
              alt="Carousel Slide"
            />
          </div>
          <div className="carousel-item">
            <img
              src={carousel2}
              className="d-block w-100 carousel-image"
              alt="Carousel Slide"
            />
          </div>
          <div className="carousel-item">
            <img
              src={carousel3}
              className="d-block w-100 carousel-image"
              alt="Carousel Slide"
            />
          </div>
        </div>
        <button
          className="carousel-control-prev"
          type="button"
          data-bs-target="#carouselExampleCaptions"
          data-bs-slide="prev"
        >
          <span className="carousel-control-prev-icon" aria-hidden="true"></span>
          <span className="visually-hidden">Previous</span>
        </button>
        <button
          className="carousel-control-next"
          type="button"
          data-bs-target="#carouselExampleCaptions"
          data-bs-slide="next"
        >
          <span className="carousel-control-next-icon" aria-hidden="true"></span>
          <span className="visually-hidden">Next</span>
        </button>
      </div>
    </div>
  );
};

export default Carousel;
