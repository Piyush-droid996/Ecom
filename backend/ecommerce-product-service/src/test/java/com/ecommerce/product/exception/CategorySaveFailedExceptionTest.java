package com.ecommerce.product.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

class CategorySaveFailedExceptionTest {

    @Test
    void testCategorySaveFailedExceptionMessage() {
        String errorMessage = "Failed to save category due to database error";

        // Create exception instance
        CategorySaveFailedException exception = new CategorySaveFailedException(errorMessage);

        // Validate message
        assertEquals(errorMessage, exception.getMessage(), "Exception message should match the input message");
    }

    @Test
    void testCategorySaveFailedExceptionStatus() {
        String errorMessage = "Category save operation failed";

        // Create exception instance
        CategorySaveFailedException exception = new CategorySaveFailedException(errorMessage);

        // Validate that it is annotated with @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        ResponseStatus responseStatus = exception.getClass().getAnnotation(ResponseStatus.class);
        assertNotNull(responseStatus, "@ResponseStatus annotation should be present on CategorySaveFailedException");
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseStatus.value(), "The HTTP status should be INTERNAL_SERVER_ERROR");
    }

    @Test
    void testExceptionIsRuntimeException() {
        String errorMessage = "Failed to save category";

        // Create exception instance
        CategorySaveFailedException exception = new CategorySaveFailedException(errorMessage);

        // Validate inheritance
        assertTrue(exception instanceof RuntimeException, "CategorySaveFailedException should extend RuntimeException");
    }
}
