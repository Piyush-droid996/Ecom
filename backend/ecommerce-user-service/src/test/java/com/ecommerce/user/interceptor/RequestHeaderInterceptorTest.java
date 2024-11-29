package com.ecommerce.user.interceptor;

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
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

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
        when(httpServletRequest.getRequestURI()).thenReturn("/api/test");
        when(httpServletRequest.getMethod()).thenReturn("GET");

        // Act
        boolean result = requestHeaderInterceptor.preHandle(httpServletRequest, httpServletResponse, handler);

        // Assert
        verify(httpServletRequest).getRequestURI();
        verify(httpServletRequest).getMethod();
        assert result; // Ensure the method allows the request to proceed
    }

    @Test
    void testPostHandle() throws Exception {
        // Act
        requestHeaderInterceptor.postHandle(httpServletRequest, httpServletResponse, handler, modelAndView);

        // Assert
        // No exceptions should be thrown, and the default implementation should be called
        verifyNoInteractions(httpServletRequest, httpServletResponse, handler, modelAndView);
    }

    @Test
    void testAfterCompletion() throws Exception {
        // Arrange
        when(httpServletRequest.getRequestURI()).thenReturn("/api/test");
        when(httpServletRequest.getMethod()).thenReturn("POST");
        when(httpServletResponse.getStatus()).thenReturn(200);

        // Act
        requestHeaderInterceptor.afterCompletion(httpServletRequest, httpServletResponse, handler, null);

        // Assert
        verify(httpServletRequest).getRequestURI();
        verify(httpServletRequest).getMethod();
        verify(httpServletResponse).getStatus();
    }
}
