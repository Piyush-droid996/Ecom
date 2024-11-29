package com.ecommerce.product.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.product.model.Product;

class ProductServiceTest {

    @Mock
    private ProductService productService;

    private Product product;
    private MultipartFile productImage;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Mock product and product image
        product = new Product();
        product.setId(1);
        product.setTitle("Test Product");
        product.setDescription("Test Description");
        product.setPrice(new java.math.BigDecimal("19.99"));
        product.setQuantity(10);

        productImage = mock(MultipartFile.class);
        when(productImage.getOriginalFilename()).thenReturn("test-image.png");
    }

    @Test
    void testAddProduct() {
        // Act
        doNothing().when(productService).addProduct(product, productImage);

        // Call the service method
        productService.addProduct(product, productImage);

        // Assert that the method was called
        verify(productService, times(1)).addProduct(product, productImage);
    }

    @Test
    void testAddProductWithNullImage() {
        // Arrange
        MultipartFile nullImage = null;

        // Act
        doNothing().when(productService).addProduct(product, nullImage);

        // Call the service method
        productService.addProduct(product, nullImage);

        // Assert that the method was called
        verify(productService, times(1)).addProduct(product, nullImage);
    }
}
