package com.ecommerce.order.interceptor;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.slf4j.Logger;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import static org.junit.jupiter.api.Assertions.*;

class RequestHeaderInterceptorTest {

    private RequestHeaderInterceptor requestHeaderInterceptor;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private Logger logger;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize the mocks
        requestHeaderInterceptor = new RequestHeaderInterceptor();
        
        // Inject the mocked logger into the interceptor
        ReflectionTestUtils.setField(requestHeaderInterceptor, "LOG", logger);
    }

    @Test
    void testPreHandle() throws Exception {
        // Arrange
        String requestURI = "/test-endpoint";
        String methodType = "GET";
        when(request.getRequestURI()).thenReturn(requestURI);
        when(request.getMethod()).thenReturn(methodType);

        // Act
        boolean result = requestHeaderInterceptor.preHandle(request, response, new Object());

        // Assert
        assertTrue(result);  // The method should return true

        // Verify logger interactions
        verify(logger).info("preHandle() method invoked");
        verify(logger).info("--------------- Request Start ---------------");
        verify(logger).info("Request URL: /test-endpoint");
        verify(logger).info("Method Type: GET");
    }

    @Test
    void testAfterCompletion() throws Exception {
        // Arrange
        String requestURI = "/test-endpoint";
        String methodType = "POST";
        int status = 200;
        when(request.getRequestURI()).thenReturn(requestURI);
        when(request.getMethod()).thenReturn(methodType);
        when(response.getStatus()).thenReturn(status);

        // Act
        requestHeaderInterceptor.afterCompletion(request, response, new Object(), null);

        // Assert
        // Verify logger interactions
        verify(logger).info("afterCompletion() method invoked");
        verify(logger).info("Request URL: /test-endpoint");
        verify(logger).info("Method Type: POST");
        verify(logger).info("Status: 200");
        verify(logger).info("--------------- Request End ---------------");
    }
}
