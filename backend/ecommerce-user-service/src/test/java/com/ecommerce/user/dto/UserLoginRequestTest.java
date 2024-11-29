package com.ecommerce.user.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserLoginRequestTest {

    @Test
    void testSettersAndGetters() {
        UserLoginRequest request = new UserLoginRequest();

        // Setting values
        request.setEmailId("test@example.com");
        request.setPassword("password123");
        request.setRole("admin");
        request.setNewPassword("newPassword123");

        // Testing getters
        assertEquals("test@example.com", request.getEmailId(), "Email ID should match.");
        assertEquals("password123", request.getPassword(), "Password should match.");
        assertEquals("admin", request.getRole(), "Role should match.");
        assertEquals("newPassword123", request.getNewPassword(), "New Password should match.");
    }

    @Test
    void testValidateLoginRequest() {
        UserLoginRequest request = new UserLoginRequest();
        
        // Incomplete login request
        request.setEmailId("test@example.com");
        request.setPassword("password123");

        assertFalse(UserLoginRequest.validateLoginRequest(request), "Login request should be invalid without a role.");

        // Complete login request
        request.setRole("user");
        assertTrue(UserLoginRequest.validateLoginRequest(request), "Login request should be valid with all fields.");
    }

    @Test
    void testValidateForgetRequest() {
        UserLoginRequest request = new UserLoginRequest();

        // Incomplete forget request
        request.setEmailId("test@example.com");
        request.setPassword("password123");

        assertFalse(UserLoginRequest.validateForgetRequest(request), "Forget request should be invalid without a new password.");

        // Complete forget request
        request.setNewPassword("newPassword123");
        assertTrue(UserLoginRequest.validateForgetRequest(request), "Forget request should be valid with all fields.");
    }

    @Test
    void testDefaultValues() {
        UserLoginRequest request = new UserLoginRequest();

        // Testing default values
        assertEquals(null, request.getEmailId(), "Default emailId should be null.");
        assertEquals(null, request.getPassword(), "Default password should be null.");
        assertEquals(null, request.getRole(), "Default role should be null.");
        assertEquals(null, request.getNewPassword(), "Default newPassword should be null.");
    }
}
