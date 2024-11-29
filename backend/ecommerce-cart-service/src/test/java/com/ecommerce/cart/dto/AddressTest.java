package com.ecommerce.cart.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Address address = new Address();
        int id = 1;
        String street = "123 Main St";
        String city = "Sample City";
        int pincode = 123456;

        // Act
        address.setId(id);
        address.setStreet(street);
        address.setCity(city);
        address.setPincode(pincode);

        // Assert
        assertEquals(id, address.getId(), "ID should match the value set");
        assertEquals(street, address.getStreet(), "Street should match the value set");
        assertEquals(city, address.getCity(), "City should match the value set");
        assertEquals(pincode, address.getPincode(), "Pincode should match the value set");
    }

    @Test
    void testToString() {
        // Arrange
        Address address = new Address();
        address.setId(1);
        address.setStreet("123 Main St");
        address.setCity("Sample City");
        address.setPincode(123456);

        String expectedToString = "Address [id=1, street=123 Main St, city=Sample City, pincode=123456]";

        // Act
        String actualToString = address.toString();

        // Assert
        assertEquals(expectedToString, actualToString, "toString() should return the expected string representation");
    }
}
