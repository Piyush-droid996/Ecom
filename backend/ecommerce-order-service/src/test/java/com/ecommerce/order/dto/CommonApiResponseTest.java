package com.ecommerce.order.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommonApiResponseTest {

    private CommonApiResponse commonApiResponse;

    @BeforeEach
    void setUp() {
        commonApiResponse = new CommonApiResponse();
    }

    @Test
    void testGettersAndSetters() {
        // Arrange
        String expectedResponseMessage = "Success";
        boolean expectedIsSuccess = true;

        // Act
        commonApiResponse.setResponseMessage(expectedResponseMessage);
        commonApiResponse.setSuccess(expectedIsSuccess);

        // Assert
        assertEquals(expectedResponseMessage, commonApiResponse.getResponseMessage(), "Response message should match the value set");
        assertTrue(commonApiResponse.isSuccess(), "isSuccess should return true");
    }

    @Test
    void testDefaultValues() {
        // Act & Assert
        assertEquals(null, commonApiResponse.getResponseMessage(), "Default responseMessage should be null");
        assertFalse(commonApiResponse.isSuccess(), "Default isSuccess should be false");
    }

    @Test
    void testToString() {
        // Arrange
        commonApiResponse.setResponseMessage("Request processed successfully");
        commonApiResponse.setSuccess(true);

        // Act
        String commonApiResponseString = commonApiResponse.toString();

        // Assert
        assertEquals("CommonApiResponse [responseMessage=Request processed successfully, isSuccess=true]", commonApiResponseString, "toString output should match expected format");
    }
}
