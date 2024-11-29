package com.ecommerce.cart.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Category category = new Category();
        int expectedId = 1;
        String expectedTitle = "Electronics";
        String expectedDescription = "All types of electronic products";

        // Act
        category.setId(expectedId);
        category.setTitle(expectedTitle);
        category.setDescription(expectedDescription);

        // Assert
        assertEquals(expectedId, category.getId(), "ID should match the value set");
        assertEquals(expectedTitle, category.getTitle(), "Title should match the value set");
        assertEquals(expectedDescription, category.getDescription(), "Description should match the value set");
    }

    @Test
    void testToString() {
        // Arrange
        Category category = new Category();
        category.setId(1);
        category.setTitle("Electronics");
        category.setDescription("All types of electronic products");

        String expectedToString = "Category [id=1, title=Electronics, description=All types of electronic products]";

        // Act
        String actualToString = category.toString();

        // Assert
        assertEquals(expectedToString, actualToString, "toString() should return the expected string representation");
    }

    @Test
    void testNotNullValues() {
        // Arrange
        Category category = new Category();
        category.setId(1);
        category.setTitle("Electronics");
        category.setDescription("All types of electronic products");

        // Act & Assert
        assertNotNull(category.getId(), "ID should not be null");
        assertNotNull(category.getTitle(), "Title should not be null");
        assertNotNull(category.getDescription(), "Description should not be null");
    }
}
