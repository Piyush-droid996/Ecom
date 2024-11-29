package com.ecommerce.order.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartDataResponseTest {

    private CartDataResponse cartDataResponse;

    @BeforeEach
    void setUp() {
        cartDataResponse = new CartDataResponse();
    }

    @Test
    void testGettersAndSetters() {
        // Arrange
        int expectedCartId = 1;
        int expectedProductId = 101;
        String expectedProductName = "Product Name";
        String expectedProductDescription = "Product Description";
        String expectedProductImage = "product-image.jpg";
        int expectedQuantity = 2;

        // Act
        cartDataResponse.setCartId(expectedCartId);
        cartDataResponse.setProductId(expectedProductId);
        cartDataResponse.setProductName(expectedProductName);
        cartDataResponse.setProductDescription(expectedProductDescription);
        cartDataResponse.setProductImage(expectedProductImage);
        cartDataResponse.setQuantity(expectedQuantity);

        // Assert
        assertEquals(expectedCartId, cartDataResponse.getCartId(), "Cart ID should match the value set");
        assertEquals(expectedProductId, cartDataResponse.getProductId(), "Product ID should match the value set");
        assertEquals(expectedProductName, cartDataResponse.getProductName(), "Product name should match the value set");
        assertEquals(expectedProductDescription, cartDataResponse.getProductDescription(), "Product description should match the value set");
        assertEquals(expectedProductImage, cartDataResponse.getProductImage(), "Product image should match the value set");
        assertEquals(expectedQuantity, cartDataResponse.getQuantity(), "Quantity should match the value set");
    }

    @Test
    void testDefaultValues() {
        // Act & Assert
        assertEquals(0, cartDataResponse.getCartId(), "Default Cart ID should be 0");
        assertEquals(0, cartDataResponse.getProductId(), "Default Product ID should be 0");
        assertEquals(null, cartDataResponse.getProductName(), "Default Product Name should be null");
        assertEquals(null, cartDataResponse.getProductDescription(), "Default Product Description should be null");
        assertEquals(null, cartDataResponse.getProductImage(), "Default Product Image should be null");
        assertEquals(0, cartDataResponse.getQuantity(), "Default Quantity should be 0");
    }

    @Test
    void testToString() {
        // Arrange
        cartDataResponse.setCartId(1);
        cartDataResponse.setProductId(101);
        cartDataResponse.setProductName("Product Name");
        cartDataResponse.setProductDescription("Product Description");
        cartDataResponse.setProductImage("product-image.jpg");
        cartDataResponse.setQuantity(2);

        // Act
        String cartDataResponseString = cartDataResponse.toString();

        // Assert
        assertNotNull(cartDataResponseString, "toString should not return null");
        assertEquals("CartDataResponse [cartId=1, productId=101, productName=Product Name, productDescription=Product Description, productImage=product-image.jpg, quantity=2]", cartDataResponseString, "toString output should match expected format");
    }
}
