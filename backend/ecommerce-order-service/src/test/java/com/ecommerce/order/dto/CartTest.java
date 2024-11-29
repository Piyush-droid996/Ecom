package com.ecommerce.order.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartTest {

    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    void testGettersAndSetters() {
        // Arrange
        int expectedId = 1;
        int expectedProductId = 1001;
        int expectedUserId = 501;
        int expectedQuantity = 3;

        // Act
        cart.setId(expectedId);
        cart.setProductId(expectedProductId);
        cart.setUserId(expectedUserId);
        cart.setQuantity(expectedQuantity);

        // Assert
        assertEquals(expectedId, cart.getId(), "ID should match the value set");
        assertEquals(expectedProductId, cart.getProductId(), "Product ID should match the value set");
        assertEquals(expectedUserId, cart.getUserId(), "User ID should match the value set");
        assertEquals(expectedQuantity, cart.getQuantity(), "Quantity should match the value set");
    }

    @Test
    void testDefaultValues() {
        // Act & Assert
        assertEquals(0, cart.getId(), "Default ID should be 0");
        assertEquals(0, cart.getProductId(), "Default Product ID should be 0");
        assertEquals(0, cart.getUserId(), "Default User ID should be 0");
        assertEquals(0, cart.getQuantity(), "Default Quantity should be 0");
    }

    @Test
    void testToString() {
        // Arrange
        cart.setId(1);
        cart.setProductId(1001);
        cart.setUserId(501);
        cart.setQuantity(3);

        // Act
        String cartString = cart.toString();

        // Assert
        assertNotNull(cartString, "toString should not return null");
        assertEquals("Cart [id=1, productId=1001, userId=501, quantity=3]", cartString, "toString output should match expected format");
    }
}
