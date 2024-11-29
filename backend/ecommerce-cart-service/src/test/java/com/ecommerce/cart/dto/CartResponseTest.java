package com.ecommerce.cart.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CartResponseTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        CartResponse response = new CartResponse();
        String totalCartPrice = "100.50";
        CartDataResponse cartDataResponse1 = new CartDataResponse();
        cartDataResponse1.setCartId(1);
        cartDataResponse1.setProductId(101);
        cartDataResponse1.setProductName("Sample Product 1");
        cartDataResponse1.setProductDescription("Description for product 1");
        cartDataResponse1.setProductImage("product1.jpg");
        cartDataResponse1.setQuantity(2);
        
        CartDataResponse cartDataResponse2 = new CartDataResponse();
        cartDataResponse2.setCartId(2);
        cartDataResponse2.setProductId(102);
        cartDataResponse2.setProductName("Sample Product 2");
        cartDataResponse2.setProductDescription("Description for product 2");
        cartDataResponse2.setProductImage("product2.jpg");
        cartDataResponse2.setQuantity(1);
        
        // Act
        response.setTotalCartPrice(totalCartPrice);
        response.setCartData(Arrays.asList(cartDataResponse1, cartDataResponse2));

        // Assert
        assertEquals(totalCartPrice, response.getTotalCartPrice(), "Total cart price should match the value set");
        assertTrue(response.getCartData().contains(cartDataResponse1), "Cart data should contain the first product");
        assertTrue(response.getCartData().contains(cartDataResponse2), "Cart data should contain the second product");
    }

    @Test
    void testToString() {
        // Arrange
        CartResponse response = new CartResponse();
        response.setTotalCartPrice("100.50");

        CartDataResponse cartDataResponse1 = new CartDataResponse();
        cartDataResponse1.setCartId(1);
        cartDataResponse1.setProductId(101);
        cartDataResponse1.setProductName("Sample Product 1");
        cartDataResponse1.setProductDescription("Description for product 1");
        cartDataResponse1.setProductImage("product1.jpg");
        cartDataResponse1.setQuantity(2);

        response.setCartData(Arrays.asList(cartDataResponse1));

        String expectedToString = "CartResponse [totalCartPrice=100.50, cartData=[CartDataResponse [cartId=1, productId=101, productName=Sample Product 1, productDescription=Description for product 1, productImage=product1.jpg, quantity=2]]]";

        // Act
        String actualToString = response.toString();

        // Assert
        assertEquals(expectedToString, actualToString, "toString() should return the expected string representation");
    }
}
