package com.ecommerce.cart.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ServiceDownExceptionTest {

    @Test
    void testServiceDownExceptionMessage() {
        // Arrange
        String exceptionMessage = "Service is currently unavailable";

        // Act
        ServiceDownException exception = new ServiceDownException(exceptionMessage);

        // Assert
        assertEquals(exceptionMessage, exception.getMessage(), 
            "Exception message should match the message passed in the constructor");
    }

    @Test
    void testServiceDownExceptionInheritance() {
        // Arrange & Act
        ServiceDownException exception = new ServiceDownException("Test");

        // Assert
        assertTrue(exception instanceof RuntimeException, 
            "ServiceDownException should be a subclass of RuntimeException");
    }
}
