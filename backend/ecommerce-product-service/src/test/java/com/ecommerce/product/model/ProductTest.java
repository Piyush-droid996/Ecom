package com.ecommerce.product.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

    private Product product;
    private Category category;

    @BeforeEach
    void setUp() {
        // Initialize the Product object and Category object before each test
        product = new Product();
        category = new Category();
        category.setId(1);
        category.setTitle("Electronics");
    }

    @Test
    void testGetSetId() {
        // Arrange
        int id = 1;

        // Act
        product.setId(id);

        // Assert
        assertEquals(id, product.getId(), "The product ID should be set and retrieved correctly.");
    }

    @Test
    void testGetSetTitle() {
        // Arrange
        String title = "Smartphone";

        // Act
        product.setTitle(title);

        // Assert
        assertEquals(title, product.getTitle(), "The product title should be set and retrieved correctly.");
    }

    @Test
    void testGetSetDescription() {
        // Arrange
        String description = "Latest model with high performance.";

        // Act
        product.setDescription(description);

        // Assert
        assertEquals(description, product.getDescription(), "The product description should be set and retrieved correctly.");
    }

    @Test
    void testGetSetQuantity() {
        // Arrange
        int quantity = 10;

        // Act
        product.setQuantity(quantity);

        // Assert
        assertEquals(quantity, product.getQuantity(), "The product quantity should be set and retrieved correctly.");
    }

    @Test
    void testGetSetPrice() {
        // Arrange
        BigDecimal price = new BigDecimal("599.99");

        // Act
        product.setPrice(price);

        // Assert
        assertEquals(price, product.getPrice(), "The product price should be set and retrieved correctly.");
    }

    @Test
    void testGetSetImageName() {
        // Arrange
        String imageName = "smartphone_image.jpg";

        // Act
        product.setImageName(imageName);

        // Assert
        assertEquals(imageName, product.getImageName(), "The product image name should be set and retrieved correctly.");
    }

    @Test
    void testGetSetCategory() {
        // Act
        product.setCategory(category);

        // Assert
        assertNotNull(product.getCategory(), "The product's category should be set and retrieved correctly.");
        assertEquals(category.getId(), product.getCategory().getId(), "The product's category ID should match.");
        assertEquals(category.getTitle(), product.getCategory().getTitle(), "The product's category name should match.");
    }
}
