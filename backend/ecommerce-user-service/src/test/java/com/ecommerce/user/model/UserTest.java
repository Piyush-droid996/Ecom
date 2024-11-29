package com.ecommerce.user.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user;
    private Address address;

    @BeforeEach
    void setUp() {
        user = new User();
        address = new Address();
    }

    @Test
    void testGettersAndSetters() {
        // Arrange
        int id = 1;
        String firstName = "John";
        String lastName = "Doe";
        String emailId = "john.doe@example.com";
        String password = "password123";
        String phoneNo = "1234567890";
        String role = "ADMIN";

        address.setStreet("123 Main St");
        address.setCity("Springfield");
        address.setPincode(12345);

        // Act
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailId(emailId);
        user.setPassword(password);
        user.setPhoneNo(phoneNo);
        user.setRole(role);
        user.setAddress(address);

        // Assert
        assertEquals(id, user.getId());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(emailId, user.getEmailId());
        assertEquals(password, user.getPassword());
        assertEquals(phoneNo, user.getPhoneNo());
        assertEquals(role, user.getRole());
        assertEquals(address, user.getAddress());
    }

    @Test
    void testToString() {
        // Arrange
        user.setId(1);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmailId("john.doe@example.com");
        user.setPassword("password123");
        user.setPhoneNo("1234567890");

        address.setStreet("123 Main St");
        address.setCity("Springfield");
        address.setPincode(12345);
        user.setAddress(address);

        // Act
        String result = user.toString();

        // Assert
        assertTrue(result.contains("John"));
        assertTrue(result.contains("Doe"));
        assertTrue(result.contains("123 Main St"));
    }
}
