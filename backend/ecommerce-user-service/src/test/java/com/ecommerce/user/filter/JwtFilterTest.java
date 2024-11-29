package com.ecommerce.user.filter;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.ecommerce.user.config.CustomUserDetailsService;
import com.ecommerce.user.utility.JwtUtil;

class JwtFilterTest {

    @InjectMocks
    private JwtFilter jwtFilter;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private CustomUserDetailsService customUserDetailsService;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

    @Mock
    private FilterChain filterChain;

    @Mock
    private UserDetails userDetails;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDoFilterInternal_ValidToken() throws ServletException, IOException {
        // Arrange
        String token = "valid-jwt-token";
        String username = "testUser";

        when(httpServletRequest.getHeader("Authorization")).thenReturn("Bearer " + token);
        when(jwtUtil.extractUsername(token)).thenReturn(username);
        when(customUserDetailsService.loadUserByUsername(username)).thenReturn(userDetails);
        when(jwtUtil.validateToken(token, userDetails)).thenReturn(true);

        // Act
        jwtFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

        // Assert
        verify(jwtUtil).extractUsername(token);
        verify(customUserDetailsService).loadUserByUsername(username);
        verify(jwtUtil).validateToken(token, userDetails);
        verify(filterChain).doFilter(httpServletRequest, httpServletResponse);

        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        assert authentication.getPrincipal().equals(userDetails);
    }

    @Test
    void testDoFilterInternal_InvalidToken() throws ServletException, IOException {
        // Arrange
        String token = "invalid-jwt-token";

        when(httpServletRequest.getHeader("Authorization")).thenReturn("Bearer " + token);
        when(jwtUtil.extractUsername(token)).thenReturn(null);

        // Act
        jwtFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

        // Assert
        verify(jwtUtil).extractUsername(token);
        verifyNoInteractions(customUserDetailsService);
        verify(filterChain).doFilter(httpServletRequest, httpServletResponse);
        assert SecurityContextHolder.getContext().getAuthentication() == null;
    }

    @Test
    void testDoFilterInternal_NoAuthorizationHeader() throws ServletException, IOException {
        // Arrange
        when(httpServletRequest.getHeader("Authorization")).thenReturn(null);

        // Act
        jwtFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

        // Assert
        verifyNoInteractions(jwtUtil, customUserDetailsService);
        verify(filterChain).doFilter(httpServletRequest, httpServletResponse);
        assert SecurityContextHolder.getContext().getAuthentication() == null;
    }

    @Test
    void testDoFilterInternal_ExpiredToken() throws ServletException, IOException {
        // Arrange
        String token = "expired-jwt-token";
        String username = "testUser";

        when(httpServletRequest.getHeader("Authorization")).thenReturn("Bearer " + token);
        when(jwtUtil.extractUsername(token)).thenReturn(username);
        when(customUserDetailsService.loadUserByUsername(username)).thenReturn(userDetails);
        when(jwtUtil.validateToken(token, userDetails)).thenReturn(false);

        // Act
        jwtFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

        // Assert
        verify(jwtUtil).extractUsername(token);
        verify(customUserDetailsService).loadUserByUsername(username);
        verify(jwtUtil).validateToken(token, userDetails);
        verify(filterChain).doFilter(httpServletRequest, httpServletResponse);
        assert SecurityContextHolder.getContext().getAuthentication() == null;
    }
}
