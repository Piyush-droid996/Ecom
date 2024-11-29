package com.ecommerce.product.interceptor;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

class RequestHeaderInterceptorTest {

    private RequestHeaderInterceptor requestHeaderInterceptor;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private Object handler;

    @Mock
    private ModelAndView modelAndView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        requestHeaderInterceptor = new RequestHeaderInterceptor();
    }

    @Test
    void testPreHandle() throws Exception {
        // Arrange
        when(request.getRequestURI()).thenReturn("/api/test");
        when(request.getMethod()).thenReturn("GET");

        // Act
        boolean result = requestHeaderInterceptor.preHandle(request, response, handler);

        // Assert
        assertTrue(result); // Ensure it returns true
        verify(request, times(1)).getRequestURI();
        verify(request, times(1)).getMethod();
    }

    @Test
    void testPostHandle() throws Exception {
        // Act
        requestHeaderInterceptor.postHandle(request, response, handler, modelAndView);

        // Assert
        // No exception thrown ensures the method works correctly
        verifyNoInteractions(request, response, handler, modelAndView);
    }

    @Test
    void testAfterCompletion() throws Exception {
        // Arrange
        when(request.getRequestURI()).thenReturn("/api/test");
        when(request.getMethod()).thenReturn("GET");
        when(response.getStatus()).thenReturn(200);

        // Act
        requestHeaderInterceptor.afterCompletion(request, response, handler, null);

        // Assert
        verify(request, times(1)).getRequestURI();
        verify(request, times(1)).getMethod();
        verify(response, times(1)).getStatus();
    }
}
