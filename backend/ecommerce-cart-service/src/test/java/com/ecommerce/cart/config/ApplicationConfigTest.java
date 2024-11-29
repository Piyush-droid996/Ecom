package com.ecommerce.cart.config;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.ecommerce.cart.interceptor.RequestHeaderInterceptor;

class ApplicationConfigTest {

    @Mock
    private RequestHeaderInterceptor requestHeaderInterceptor;

    @Mock
    private InterceptorRegistry interceptorRegistry;

    @InjectMocks
    private ApplicationConfig applicationConfig;

    public ApplicationConfigTest() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testAddInterceptors() {
        // Act
        applicationConfig.addInterceptors(interceptorRegistry);

        // Assert
        verify(interceptorRegistry, times(1)).addInterceptor(requestHeaderInterceptor);
    }
}
