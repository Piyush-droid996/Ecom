package com.ecommerce.product.config;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.ecommerce.product.interceptor.RequestHeaderInterceptor;

class ApplicationConfigTest {

    @Mock
    private RequestHeaderInterceptor requestHeaderInterceptor;

    @Mock
    private InterceptorRegistry interceptorRegistry;

    @InjectMocks
    private ApplicationConfig applicationConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddInterceptors() {
        // Act
        applicationConfig.addInterceptors(interceptorRegistry);

        // Assert
        verify(interceptorRegistry, times(1)).addInterceptor(requestHeaderInterceptor);
    }
}
