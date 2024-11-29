package com.ecommerce.product.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.product.dto.CommonApiResponse;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void testHandleCategorySaveFailedException() {
        // Mock exception
        String errorMessage = "Failed to save category";
        CategorySaveFailedException exception = new CategorySaveFailedException(errorMessage);

        // Call the method
        ResponseEntity<CommonApiResponse> responseEntity = globalExceptionHandler.handleCategorySaveFailedException(exception);

        // Assertions
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode(), 
            "HTTP status should be INTERNAL_SERVER_ERROR");

        CommonApiResponse responseBody = responseEntity.getBody();
        assertEquals(errorMessage, responseBody.getResponseMessage(), 
            "Response message should match the exception message");
        assertEquals(false, responseBody.isSuccess(), 
            "Success flag should be false for CategorySaveFailedException");
    }
}
