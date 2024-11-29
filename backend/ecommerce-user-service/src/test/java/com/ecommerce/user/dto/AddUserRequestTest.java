package com.ecommerce.user.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddUserRequestTest {

    private AddUserRequest validRequest;
    private AddUserRequest invalidRequest;

    @BeforeEach
    void setUp() {
        // Setting up a valid AddUserRequest object
        validRequest = new AddUserRequest();
        validRequest.setFirstName("John");
        validRequest.setLastName("Doe");
        validRequest.setEmailId("john.doe@example.com");
        validRequest.setPassword("password123");
        validRequest.setPhoneNo("1234567890");
        validRequest.setStreet("123 Main St");
        validRequest.setCity("New York");
        validRequest.setPincode(12345);
        validRequest.setRole("user");

        // Setting up an invalid AddUserRequest object
        invalidRequest = new AddUserRequest();
        invalidRequest.setFirstName(null); // Missing firstName
        invalidRequest.setLastName("Doe");
        invalidRequest.setEmailId(null); // Missing emailId
        invalidRequest.setPassword("password123");
        invalidRequest.setPhoneNo("1234567890");
        invalidRequest.setStreet("123 Main St");
        invalidRequest.setCity("New York");
        invalidRequest.setPincode(12345);
        invalidRequest.setRole("user");
    }

    @Test
    void testValidateWithValidRequest() {
        // Valid request should return true
        boolean isValid = AddUserRequest.validate(validRequest);
        assertTrue(isValid, "The validation for a valid request should return true.");
    }

    @Test
    void testValidateWithInvalidRequest() {
        // Invalid request should return false
        boolean isInvalid = AddUserRequest.validate(invalidRequest);
        assertFalse(isInvalid, "The validation for an invalid request should return false.");
    }

    @Test
    void testSettersAndGetters() {
        // Testing all the setters and getters for the validRequest object
        AddUserRequest request = new AddUserRequest();
        request.setFirstName("Jane");
        request.setLastName("Smith");
        request.setEmailId("jane.smith@example.com");
        request.setPassword("securepassword");
        request.setPhoneNo("9876543210");
        request.setStreet("456 Elm St");
        request.setCity("Los Angeles");
        request.setPincode(54321);
        request.setRole("admin");

        assertTrue(request.getFirstName().equals("Jane"));
        assertTrue(request.getLastName().equals("Smith"));
        assertTrue(request.getEmailId().equals("jane.smith@example.com"));
        assertTrue(request.getPassword().equals("securepassword"));
        assertTrue(request.getPhoneNo().equals("9876543210"));
        assertTrue(request.getStreet().equals("456 Elm St"));
        assertTrue(request.getCity().equals("Los Angeles"));
        assertTrue(request.getPincode() == 54321);
        assertTrue(request.getRole().equals("admin"));
    }

    @Test
    void testToString() {
        // Testing the toString method
        String expectedToString = "AddUserRequest [firstName=John, lastName=Doe, emailId=john.doe@example.com, password=password123, phoneNo=1234567890, street=123 Main St, city=New York, pincode=12345]";
        assertTrue(validRequest.toString().equals(expectedToString));
    }
}
