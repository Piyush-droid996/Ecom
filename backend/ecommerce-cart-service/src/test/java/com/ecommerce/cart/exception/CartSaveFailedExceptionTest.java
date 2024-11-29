package com.ecommerce.cart.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CartSaveFailedExceptionTest {

    @Test
    void testCartSaveFailedExceptionMessage() {
        // Arrange
        String expectedMessage = "Failed to save cart";

        // Act
        CartSaveFailedException exception = assertThrows(CartSaveFailedException.class, () -> {
            throw new CartSaveFailedException(expectedMessage);
        });

        // Assert
        assertEquals(expectedMessage, exception.getMessage(), 
            "Exception message should match the provided message");
    }
}
