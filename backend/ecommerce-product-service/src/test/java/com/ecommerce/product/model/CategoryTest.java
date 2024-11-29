package com.ecommerce.product.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

    private Category category;

    @BeforeEach
    void setUp() {
        // Initialize the Category object before each test
        category = new Category();
    }

    @Test
    void testGetSetId() {
        // Arrange
        int id = 1;

        // Act
        category.setId(id);

        // Assert
        assertEquals(id, category.getId(), "The category ID should be set and retrieved correctly.");
    }

    @Test
    void testGetSetTitle() {
        // Arrange
        String title = "Electronics";

        // Act
        category.setTitle(title);

        // Assert
        assertEquals(title, category.getTitle(), "The category title should be set and retrieved correctly.");
    }

    @Test
    void testGetSetDescription() {
        // Arrange
        String description = "Devices and gadgets";

        // Act
        category.setDescription(description);

        // Assert
        assertEquals(description, category.getDescription(), "The category description should be set and retrieved correctly.");
    }
}
