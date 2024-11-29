package com.ecommerce.product.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommonApiResponseTest {

    private CommonApiResponse commonApiResponse;

    @BeforeEach
    void setUp() {
        commonApiResponse = new CommonApiResponse();
    }

    @Test
    void testGetResponseMessage_whenNotSet_shouldReturnNull() {
        // Act
        String responseMessage = commonApiResponse.getResponseMessage();

        // Assert
        assertNull(responseMessage, "Response message should be null when not set");
    }

    @Test
    void testSetResponseMessage_shouldSetCorrectMessage() {
        // Arrange
        String message = "Request was successful";

        // Act
        commonApiResponse.setResponseMessage(message);

        // Assert
        assertEquals(message, commonApiResponse.getResponseMessage(), "Response message should be correctly set");
    }

    @Test
    void testGetIsSuccess_whenNotSet_shouldReturnFalse() {
        // Act
        boolean isSuccess = commonApiResponse.isSuccess();

        // Assert
        assertFalse(isSuccess, "Success flag should be false by default");
    }

    @Test
    void testSetSuccess_shouldSetSuccessFlag() {
        // Act
        commonApiResponse.setSuccess(true);

        // Assert
        assertTrue(commonApiResponse.isSuccess(), "Success flag should be true after being set");
    }

    @Test
    void testSetAndGetResponseMessage() {
        // Arrange
        String expectedMessage = "Operation completed successfully";

        // Act
        commonApiResponse.setResponseMessage(expectedMessage);

        // Assert
        assertEquals(expectedMessage, commonApiResponse.getResponseMessage(), "The response message should be as set");
    }

    @Test
    void testSetAndGetSuccess() {
        // Arrange
        boolean expectedSuccess = false;

        // Act
        commonApiResponse.setSuccess(expectedSuccess);

        // Assert
        assertFalse(commonApiResponse.isSuccess(), "The success flag should be set as false");
    }
}
