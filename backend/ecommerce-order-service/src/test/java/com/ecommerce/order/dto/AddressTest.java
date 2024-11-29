package com.ecommerce.order.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        int expectedId = 1;
        String expectedStreet = "123 Main St";
        String expectedCity = "Cityville";
        int expectedPincode = 123456;

        // Act
        address.setId(expectedId);
        address.setStreet(expectedStreet);
        address.setCity(expectedCity);
        address.setPincode(expectedPincode);

        // Assert
        assertEquals(expectedId, address.getId(), "ID should match the value set");
        assertEquals(expectedStreet, address.getStreet(), "Street should match the value set");
        assertEquals(expectedCity, address.getCity(), "City should match the value set");
        assertEquals(expectedPincode, address.getPincode(), "Pincode should match the value set");
    }

    @Test
    void testToString() {
        // Arrange
        address.setId(1);
        address.setStreet("123 Main St");
        address.setCity("Cityville");
        address.setPincode(123456);

        // Act
        String addressString = address.toString();

        // Assert
        assertNotNull(addressString, "toString should not return null");
        assertEquals("Address [id=1, street=123 Main St, city=Cityville, pincode=123456]", addressString, "toString output should match expected format");
    }

    @Test
    void testDefaultValues() {
        // Act & Assert
        assertEquals(0, address.getId(), "Default ID should be 0");
        assertEquals(null, address.getStreet(), "Default street should be null");
        assertEquals(null, address.getCity(), "Default city should be null");
        assertEquals(0, address.getPincode(), "Default pincode should be 0");
    }
}
