import { useState } from "react";
import { useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "./AddCardDetails.css"

const AddCardDetails = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const user = JSON.parse(sessionStorage.getItem("active-user"));
  const priceToPay = location.state.priceToPay;
  let userToken = sessionStorage.getItem("user-jwtToken");

  const [card, setCard] = useState({
    cardName: "",
    cardNumber: "",
    validThrough: "",
    cvv: "",
  });

  const [errors, setErrors] = useState({});

  const handleCardInput = (e) => {
    setCard({ ...card, [e.target.name]: e.target.value });
  };

  const validateInputs = () => {
    const errors = {};

    // Validate Name on Card
    if (!card.cardName.trim()) {
      errors.cardName = "Name on card is required.";
    } else if (/\d/.test(card.cardName)) {
      errors.cardName = "Name on card cannot contain numbers.";
    }

    // Validate Card Number
    if (!card.cardNumber) {
      errors.cardNumber = "Card number is required.";
    } else if (!/^\d{16}$/.test(card.cardNumber)) {
      errors.cardNumber = "Card number must be 16 digits.";
    }

    // Validate Valid Through
    if (!card.validThrough) {
      errors.validThrough = "Valid through date is required.";
    } else if (!/^\d{2}\/\d{2}$/.test(card.validThrough)) {
      errors.validThrough = "Valid through must be in MM/YY format.";
    } else {
      const [month, year] = card.validThrough.split("/").map(Number);
      const currentDate = new Date();
      const currentYear = currentDate.getFullYear() % 100; // Last two digits of the current year
      const currentMonth = currentDate.getMonth() + 1;

      if (month < 1 || month > 12) {
        errors.validThrough = "Invalid month in valid through.";
      } else if (year < currentYear || (year === currentYear && month < currentMonth)) {
        errors.validThrough = "Valid through date must be in the future.";
      }
    }

    // Validate CVV
    if (!card.cvv) {
      errors.cvv = "CVV is required.";
    } else if (!/^\d{3}$/.test(card.cvv)) {
      errors.cvv = "CVV must be 3 digits.";
    }

    setErrors(errors);
    return Object.keys(errors).length === 0;
  };

  const payAndOrder = () => {
    fetch("http://localhost:8080/api/order/add?userId=" + user.id, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
        Authorization: `Bearer ${userToken}`,
      },
    })
      .then((result) => {
        result.json().then((res) => {
          if (res.success) {
            toast.success(res.responseMessage, {
              position: "top-center",
              autoClose: 1000,
            });

            setTimeout(() => {
              window.location.reload(true);
            }, 1000);
          } else {
            toast.error(res.responseMessage, {
              position: "top-center",
              autoClose: 1000,
            });
          }
        });
      })
      .catch((error) => {
        console.error(error);
        toast.error("It seems server is down", {
          position: "top-center",
          autoClose: 1000,
        });
      });
  };

  const payForOrder = (e) => {
    e.preventDefault();
    if (validateInputs()) {
      payAndOrder();
      toast.success("Products Ordered Successfully!!!", {
        position: "top-center",
        autoClose: 1000,
      });
      navigate("/home");
    }
  };

  return (
    <div>
      <div className="Main">
        <div className="d-flex aligns-items-center justify-content-center">
          <div className="card form-card border-color" style={{ width: "25rem" }}>
            <div className="card-header bg-color custom-bg-text">
              <h5 className="card-title text-center">Payment Details</h5>
            </div>
            <div className="card-body text-color custom-bg">
              <form onSubmit={payForOrder}>
                <div className="mb-3">
                  <label htmlFor="name" className="form-label">
                    <b> Name on Card</b>
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="name"
                    name="cardName"
                    onChange={handleCardInput}
                    value={card.cardName}
                  />
                  {errors.cardName && (
                    <small className="text-danger">{errors.cardName}</small>
                  )}
                </div>
                <div className="mb-3">
                  <label htmlFor="cardNumber" className="form-label">
                    <b> Card Number</b>
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="cardNumber"
                    name="cardNumber"
                    onChange={handleCardInput}
                    value={card.cardNumber}
                  />
                  {errors.cardNumber && (
                    <small className="text-danger">{errors.cardNumber}</small>
                  )}
                </div>
                <div className="mb-3">
                  <label htmlFor="validThrough" className="form-label">
                    <b>Valid Through</b>
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="validThrough"
                    name="validThrough"
                    onChange={handleCardInput}
                    value={card.validThrough}
                  />
                  {errors.validThrough && (
                    <small className="text-danger">{errors.validThrough}</small>
                  )}
                </div>
                <div className="mb-3">
                  <label htmlFor="cvv" className="form-label">
                    <b>CVV</b>
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="cvv"
                    name="cvv"
                    onChange={handleCardInput}
                    value={card.cvv}
                  />
                  {errors.cvv && (
                    <small className="text-danger">{errors.cvv}</small>
                  )}
                </div>
                <input
                  type="submit"
                  className="btn custom-bg-text bg-color"
                  value={"Pay Rs" + priceToPay}
                />
                <ToastContainer />
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddCardDetails;
