package com.ecommerce.user.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CommonApiResponseTest {

    @Test
    void testSettersAndGetters() {
        CommonApiResponse response = new CommonApiResponse();

        // Testing setters
        response.setResponseMessage("Operation successful");
        response.setSuccess(true);

        // Testing getters
        assertEquals("Operation successful", response.getResponseMessage(), "Response message should match.");
        assertTrue(response.isSuccess(), "isSuccess should be true.");
    }

    @Test
    void testSettersAndGettersWithFailure() {
        CommonApiResponse response = new CommonApiResponse();

        // Testing setters
        response.setResponseMessage("Operation failed");
        response.setSuccess(false);

        // Testing getters
        assertEquals("Operation failed", response.getResponseMessage(), "Response message should match.");
        assertFalse(response.isSuccess(), "isSuccess should be false.");
    }

    @Test
    void testDefaultValues() {
        CommonApiResponse response = new CommonApiResponse();

        // Testing default values
        assertEquals(null, response.getResponseMessage(), "Default response message should be null.");
        assertFalse(response.isSuccess(), "Default isSuccess should be false.");
    }
}
