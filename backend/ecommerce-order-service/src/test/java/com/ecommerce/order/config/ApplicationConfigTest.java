package com.ecommerce.order.config;

import com.ecommerce.order.interceptor.RequestHeaderInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationConfigTest {

    private ApplicationConfig applicationConfig;
    private RequestHeaderInterceptor requestHeaderInterceptor;
    private InterceptorRegistry interceptorRegistry;

    @BeforeEach
    public void setUp() {
        // Mock the interceptor and registry
        requestHeaderInterceptor = mock(RequestHeaderInterceptor.class);
        interceptorRegistry = mock(InterceptorRegistry.class);
        
        // Create the instance of the ApplicationConfig with the mocked interceptor
        applicationConfig = new ApplicationConfig();
        applicationConfig.addInterceptors(interceptorRegistry);
    }

    @Test
    public void testAddInterceptors() {
        // Call addInterceptors method
        applicationConfig.addInterceptors(interceptorRegistry);
        
        // Verify if the interceptor was added to the registry
        verify(interceptorRegistry).addInterceptor(requestHeaderInterceptor);
    }
}
