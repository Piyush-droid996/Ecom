package com.ecommerce.user.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.ecommerce.user.dto.AddUserRequest;
import com.ecommerce.user.dto.UserLoginRequest;
import com.ecommerce.user.dto.UserResponse;
import com.ecommerce.user.resource.UserResource;

class UserControllerTest {

    @Mock
    private UserResource userResource;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() {
        // Arrange
        AddUserRequest userRequest = new AddUserRequest();
        UserResponse userResponse = new UserResponse();
        when(userResource.registerUser(userRequest)).thenReturn(ResponseEntity.ok(userResponse));

        // Act
        ResponseEntity<UserResponse> response = userController.registerUser(userRequest);

        // Assert
        assertNotNull(response);
        assertEquals(ResponseEntity.ok(userResponse), response);
        verify(userResource, times(1)).registerUser(userRequest);
    }

    @Test
    void testLoginUser() {
        // Arrange
        UserLoginRequest loginRequest = new UserLoginRequest();
        UserResponse userResponse = new UserResponse();
        when(userResource.loginUser(loginRequest)).thenReturn(ResponseEntity.ok(userResponse));

        // Act
        ResponseEntity<UserResponse> response = userController.loginUser(loginRequest);

        // Assert
        assertNotNull(response);
        assertEquals(ResponseEntity.ok(userResponse), response);
        verify(userResource, times(1)).loginUser(loginRequest);
    }

    @Test
    void testGetAllDeliveryPersons() {
        // Arrange
        UserResponse userResponse = new UserResponse();
        when(userResource.getAllDeliveryPersons()).thenReturn(ResponseEntity.ok(userResponse));

        // Act
        ResponseEntity<UserResponse> response = userController.getAllDeliveryPersons();

        // Assert
        assertNotNull(response);
        assertEquals(ResponseEntity.ok(userResponse), response);
        verify(userResource, times(1)).getAllDeliveryPersons();
    }

    @Test
    void testFetchUserById() {
        // Arrange
        Integer userId = 1;
        UserResponse userResponse = new UserResponse();
        when(userResource.fetchUserById(userId)).thenReturn(ResponseEntity.ok(userResponse));

        // Act
        ResponseEntity<UserResponse> response = userController.fetchUserById(userId);

        // Assert
        assertNotNull(response);
        assertEquals(ResponseEntity.ok(userResponse), response);
        verify(userResource, times(1)).fetchUserById(userId);
    }
}
