package com.ecommerce.cart.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CartDataResponseTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        CartDataResponse response = new CartDataResponse();
        int cartId = 1;
        int productId = 101;
        String productName = "Sample Product";
        String productDescription = "This is a sample product description.";
        String productImage = "sample_image.jpg";
        int quantity = 5;

        // Act
        response.setCartId(cartId);
        response.setProductId(productId);
        response.setProductName(productName);
        response.setProductDescription(productDescription);
        response.setProductImage(productImage);
        response.setQuantity(quantity);

        // Assert
        assertEquals(cartId, response.getCartId(), "Cart ID should match the value set");
        assertEquals(productId, response.getProductId(), "Product ID should match the value set");
        assertEquals(productName, response.getProductName(), "Product name should match the value set");
        assertEquals(productDescription, response.getProductDescription(), "Product description should match the value set");
        assertEquals(productImage, response.getProductImage(), "Product image should match the value set");
        assertEquals(quantity, response.getQuantity(), "Quantity should match the value set");
    }

    @Test
    void testToString() {
        // Arrange
        CartDataResponse response = new CartDataResponse();
        response.setCartId(1);
        response.setProductId(101);
        response.setProductName("Sample Product");
        response.setProductDescription("This is a sample product description.");
        response.setProductImage("sample_image.jpg");
        response.setQuantity(5);

        String expectedToString = "CartDataResponse [cartId=1, productId=101, productName=Sample Product, "
                + "productDescription=This is a sample product description., productImage=sample_image.jpg, quantity=5]";

        // Act
        String actualToString = response.toString();

        // Assert
        assertEquals(expectedToString, actualToString, "toString() should return the expected string representation");
    }
}
