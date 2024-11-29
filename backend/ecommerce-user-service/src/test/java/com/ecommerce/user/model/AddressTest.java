package com.ecommerce.user.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressTest {

    private Address address;

    @BeforeEach
    void setUp() {
        address = new Address();
    }

    @Test
    void testGettersAndSetters() {
        // Arrange
        int id = 1;
        String street = "123 Main St";
        String city = "Springfield";
        int pincode = 12345;

        // Act
        address.setId(id);
        address.setStreet(street);
        address.setCity(city);
        address.setPincode(pincode);

        // Assert
        assertEquals(id, address.getId());
        assertEquals(street, address.getStreet());
        assertEquals(city, address.getCity());
        assertEquals(pincode, address.getPincode());
    }

    @Test
    void testToString() {
        // Arrange
        address.setId(1);
        address.setStreet("123 Main St");
        address.setCity("Springfield");
        address.setPincode(12345);

        // Act
        String result = address.toString();

        // Assert
        assertTrue(result.contains("123 Main St"));
        assertTrue(result.contains("Springfield"));
        assertTrue(result.contains("12345"));
    }
}
