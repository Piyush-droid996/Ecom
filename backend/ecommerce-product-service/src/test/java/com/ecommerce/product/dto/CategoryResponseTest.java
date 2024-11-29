package com.ecommerce.product.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ecommerce.product.model.Category;

import java.util.List;

class CategoryResponseTest {

    private CategoryResponse categoryResponse;

    @BeforeEach
    void setUp() {
        categoryResponse = new CategoryResponse();
    }

    @Test
    void testGetCategories_whenEmpty_shouldReturnEmptyList() {
        // Act
        List<Category> categories = categoryResponse.getCategories();

        // Assert
        assertNotNull(categories, "Categories list should not be null");
        assertTrue(categories.isEmpty(), "Categories list should be empty initially");
    }

    @Test
    void testSetCategories_shouldSetCategoriesList() {
        // Arrange
        Category category1 = new Category();
        category1.setTitle("Electronics");

        Category category2 = new Category();
        category2.setTitle("Furniture");

        List<Category> categoryList = List.of(category1, category2);

        // Act
        categoryResponse.setCategories(categoryList);

        // Assert
        List<Category> categories = categoryResponse.getCategories();
        assertNotNull(categories, "Categories list should not be null");
        assertEquals(2, categories.size(), "Categories list should contain two elements");
        assertEquals("Electronics", categories.get(0).getTitle(), "First category should be Electronics");
        assertEquals("Furniture", categories.get(1).getTitle(), "Second category should be Furniture");
    }

    @Test
    void testSetCategories_whenNull_shouldHandleNull() {
        // Act
        categoryResponse.setCategories(null);

        // Assert
        assertNull(categoryResponse.getCategories(), "Categories list should be null when set to null");
    }
}
