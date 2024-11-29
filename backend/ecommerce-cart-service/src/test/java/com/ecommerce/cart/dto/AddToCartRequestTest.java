package com.ecommerce.cart.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AddToCartRequestTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        AddToCartRequest request = new AddToCartRequest();
        int productId = 101;
        int quantity = 2;
        int userId = 1001;

        // Act
        request.setProductId(productId);
        request.setQuantity(quantity);
        request.setUserId(userId);

        // Assert
        assertEquals(productId, request.getProductId(), "Product ID should match the value set");
        assertEquals(quantity, request.getQuantity(), "Quantity should match the value set");
        assertEquals(userId, request.getUserId(), "User ID should match the value set");
    }

    @Test
    void testToString() {
        // Arrange
        AddToCartRequest request = new AddToCartRequest();
        request.setProductId(101);
        request.setQuantity(2);
        request.setUserId(1001);

        String expectedToString = "AddToCartRequest [productId=101, quantity=2, userId=1001]";

        // Act
        String actualToString = request.toString();

        // Assert
        assertEquals(expectedToString, actualToString, "toString() should return the expected string representation");
    }

    @Test
    void testValidateAddToCartRequest_ValidInput() {
        // Arrange
        AddToCartRequest request = new AddToCartRequest();
        request.setProductId(101);
        request.setQuantity(2);
        request.setUserId(1001);

        // Act & Assert
        assertTrue(AddToCartRequest.validateAddToCartRequest(request), "Validation should pass for valid input");
    }

    @Test
    void testValidateAddToCartRequest_InvalidProductId() {
        // Arrange
        AddToCartRequest request = new AddToCartRequest();
        request.setProductId(0); // Invalid productId
        request.setQuantity(2);
        request.setUserId(1001);

        // Act & Assert
        assertFalse(AddToCartRequest.validateAddToCartRequest(request), "Validation should fail for invalid productId");
    }

    @Test
    void testValidateAddToCartRequest_InvalidQuantity() {
        // Arrange
        AddToCartRequest request = new AddToCartRequest();
        request.setProductId(101);
        request.setQuantity(0); // Invalid quantity
        request.setUserId(1001);

        // Act & Assert
        assertFalse(AddToCartRequest.validateAddToCartRequest(request), "Validation should fail for invalid quantity");
    }

    @Test
    void testValidateAddToCartRequest_InvalidUserId() {
        // Arrange
        AddToCartRequest request = new AddToCartRequest();
        request.setProductId(101);
        request.setQuantity(2);
        request.setUserId(0); // Invalid userId

        // Act & Assert
        assertFalse(AddToCartRequest.validateAddToCartRequest(request), "Validation should fail for invalid userId");
    }
}
