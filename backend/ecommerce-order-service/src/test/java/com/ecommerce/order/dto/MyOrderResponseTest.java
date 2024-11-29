package com.ecommerce.order.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyOrderResponseTest {

    private MyOrderResponse myOrderResponse;

    @BeforeEach
    void setUp() {
        myOrderResponse = new MyOrderResponse();
    }

    @Test
    void testGettersAndSetters() {
        // Arrange
        String expectedOrderId = "ORD12345";
        int expectedProductId = 101;
        int expectedUserId = 2001;
        String expectedUserName = "John Doe";
        String expectedUserPhone = "123-456-7890";
        String expectedProductName = "Laptop";
        String expectedProductDescription = "High performance laptop";
        String expectedProductImage = "laptop.jpg";
        int expectedQuantity = 2;
        String expectedTotalPrice = "1200.00";
        String expectedOrderDate = "2024-11-01";
        String expectedDeliveryDate = "2024-11-05";
        String expectedDeliveryStatus = "Delivered";
        String expectedDeliveryPersonName = "Mike";
        String expectedDeliveryPersonContact = "987-654-3210";

        Address expectedAddress = new Address();
        expectedAddress.setStreet("123 Main St");
        expectedAddress.setCity("Springfield");
        expectedAddress.setPincode(123456);

        // Act
        myOrderResponse.setOrderId(expectedOrderId);
        myOrderResponse.setProductId(expectedProductId);
        myOrderResponse.setUserId(expectedUserId);
        myOrderResponse.setUserName(expectedUserName);
        myOrderResponse.setUserPhone(expectedUserPhone);
        myOrderResponse.setProductName(expectedProductName);
        myOrderResponse.setProductDescription(expectedProductDescription);
        myOrderResponse.setProductImage(expectedProductImage);
        myOrderResponse.setQuantity(expectedQuantity);
        myOrderResponse.setTotalPrice(expectedTotalPrice);
        myOrderResponse.setOrderDate(expectedOrderDate);
        myOrderResponse.setDeliveryDate(expectedDeliveryDate);
        myOrderResponse.setDeliveryStatus(expectedDeliveryStatus);
        myOrderResponse.setDeliveryPersonName(expectedDeliveryPersonName);
        myOrderResponse.setDeliveryPersonContact(expectedDeliveryPersonContact);
        myOrderResponse.setAddress(expectedAddress);

        // Assert
        assertEquals(expectedOrderId, myOrderResponse.getOrderId(), "Order ID should match the value set");
        assertEquals(expectedProductId, myOrderResponse.getProductId(), "Product ID should match the value set");
        assertEquals(expectedUserId, myOrderResponse.getUserId(), "User ID should match the value set");
        assertEquals(expectedUserName, myOrderResponse.getUserName(), "User Name should match the value set");
        assertEquals(expectedUserPhone, myOrderResponse.getUserPhone(), "User Phone should match the value set");
        assertEquals(expectedProductName, myOrderResponse.getProductName(), "Product Name should match the value set");
        assertEquals(expectedProductDescription, myOrderResponse.getProductDescription(), "Product Description should match the value set");
        assertEquals(expectedProductImage, myOrderResponse.getProductImage(), "Product Image should match the value set");
        assertEquals(expectedQuantity, myOrderResponse.getQuantity(), "Quantity should match the value set");
        assertEquals(expectedTotalPrice, myOrderResponse.getTotalPrice(), "Total Price should match the value set");
        assertEquals(expectedOrderDate, myOrderResponse.getOrderDate(), "Order Date should match the value set");
        assertEquals(expectedDeliveryDate, myOrderResponse.getDeliveryDate(), "Delivery Date should match the value set");
        assertEquals(expectedDeliveryStatus, myOrderResponse.getDeliveryStatus(), "Delivery Status should match the value set");
        assertEquals(expectedDeliveryPersonName, myOrderResponse.getDeliveryPersonName(), "Delivery Person Name should match the value set");
        assertEquals(expectedDeliveryPersonContact, myOrderResponse.getDeliveryPersonContact(), "Delivery Person Contact should match the value set");

        // Validate Address object
        assertNotNull(myOrderResponse.getAddress(), "Address should not be null");
        assertEquals(expectedAddress.getStreet(), myOrderResponse.getAddress().getStreet(), "Street should match");
        assertEquals(expectedAddress.getCity(), myOrderResponse.getAddress().getCity(), "City should match");
        assertEquals(expectedAddress.getPincode(), myOrderResponse.getAddress().getPincode(), "Pincode should match");
    }

    @Test
    void testToString() {
        // Arrange
        myOrderResponse.setOrderId("ORD12345");
        myOrderResponse.setProductName("Laptop");
        myOrderResponse.setQuantity(2);
        myOrderResponse.setTotalPrice("1200.00");

        // Act
        String myOrderResponseString = myOrderResponse.toString();

        // Assert
        assertEquals("MyOrderResponse [orderId=ORD12345, productId=0, userId=0, userName=null, address=null, userPhone=null, productName=Laptop, productDescription=null, productImage=null, quantity=2, totalPrice=1200.00, orderDate=null, deliveryDate=null, deliveryStatus=null, deliveryPersonName=null, deliveryPersonContact=null]", myOrderResponseString, "toString output should match expected format");
    }
}
