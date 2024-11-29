package com.ecommerce.cart.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CartTest {

    @Test
    void testCartGettersAndSetters() {
        // Create a new Cart instance
        Cart cart = new Cart();

        // Set values
        cart.setId(1);
        cart.setProductId(101);
        cart.setUserId(202);
        cart.setQuantity(3);

        // Assert that the values are set correctly
        assertEquals(1, cart.getId());
        assertEquals(101, cart.getProductId());
        assertEquals(202, cart.getUserId());
        assertEquals(3, cart.getQuantity());
    }

    @Test
    void testDefaultConstructor() {
        // Create a new Cart instance using the default constructor
        Cart cart = new Cart();

        // Assert default values (primitive fields should be 0)
        assertEquals(0, cart.getId());
        assertEquals(0, cart.getProductId());
        assertEquals(0, cart.getUserId());
        assertEquals(0, cart.getQuantity());
    }

    @Test
    void testEqualityAndHashCode() {
        // Create two Cart instances with the same values
        Cart cart1 = new Cart();
        cart1.setId(1);
        cart1.setProductId(101);
        cart1.setUserId(202);
        cart1.setQuantity(3);

        Cart cart2 = new Cart();
        cart2.setId(1);
        cart2.setProductId(101);
        cart2.setUserId(202);
        cart2.setQuantity(3);

        // Assert that they are equal (if equals and hashCode are implemented)
        assertEquals(cart1, cart2);
        assertEquals(cart1.hashCode(), cart2.hashCode());
    }

    @Test
    void testToString() {
        // Create a new Cart instance
        Cart cart = new Cart();
        cart.setId(1);
        cart.setProductId(101);
        cart.setUserId(202);
        cart.setQuantity(3);

        // Convert to string and assert it contains the expected values
        String cartString = cart.toString();
        assertTrue(cartString.contains("1"));
        assertTrue(cartString.contains("101"));
        assertTrue(cartString.contains("202"));
        assertTrue(cartString.contains("3"));
    }
}
