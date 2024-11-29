package com.ecommerce.cart.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.cart.dto.CommonApiResponse;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void testHandleCartSaveFailedException() {
        // Arrange
        String exceptionMessage = "Failed to save cart";
        CartSaveFailedException exception = new CartSaveFailedException(exceptionMessage);

        // Act
        ResponseEntity<CommonApiResponse> response = globalExceptionHandler.handleCartSaveFailedException(exception);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode(), 
            "Status code should be INTERNAL_SERVER_ERROR");
        assertEquals(false, response.getBody().isSuccess(), 
            "Success flag in response should be false");
        assertEquals(exceptionMessage, response.getBody().getResponseMessage(), 
            "Response message should match the exception message");
    }

    @Test
    void testHandleServiceDownException() {
        // Arrange
        String exceptionMessage = "Service is temporarily down";
        ServiceDownException exception = new ServiceDownException(exceptionMessage);

        // Act
        ResponseEntity<CommonApiResponse> response = globalExceptionHandler.handleServiceDownException(exception);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode(), 
            "Status code should be INTERNAL_SERVER_ERROR");
        assertEquals(false, response.getBody().isSuccess(), 
            "Success flag in response should be false");
        assertEquals(exceptionMessage, response.getBody().getResponseMessage(), 
            "Response message should match the exception message");
    }
}
