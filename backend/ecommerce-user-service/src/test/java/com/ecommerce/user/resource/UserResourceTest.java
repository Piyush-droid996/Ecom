package com.ecommerce.user.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecommerce.user.dao.AddressDao;
import com.ecommerce.user.dao.UserDao;
import com.ecommerce.user.dto.AddUserRequest;
import com.ecommerce.user.dto.UserLoginRequest;
import com.ecommerce.user.dto.UserResponse;
import com.ecommerce.user.model.Address;
import com.ecommerce.user.model.User;
import com.ecommerce.user.utility.JwtUtil;
import com.ecommerce.user.config.CustomUserDetailsService;

class UserResourceTest {

    @InjectMocks
    private UserResource userResource;

    @Mock
    private UserDao userDao;

    @Mock
    private AddressDao addressDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private CustomUserDetailsService customUserDetailsService;

    @Mock
    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser_Success() {
        AddUserRequest request = new AddUserRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setEmailId("john.doe@example.com");
        request.setPassword("password");
        request.setPhoneNo("1234567890");
        request.setCity("New York");
        request.setStreet("123 Main St");
        request.setPincode(12345);
        request.setRole("Customer");

        Address address = new Address();
        address.setId(1);
        address.setCity("New York");
        address.setStreet("123 Main St");
        address.setPincode(12345);

        User user = new User();
        user.setId(1);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmailId("john.doe@example.com");
        user.setPhoneNo("1234567890");
        user.setAddress(address);
        user.setRole("Customer");

        when(addressDao.save(any(Address.class))).thenReturn(address);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userDao.save(any(User.class))).thenReturn(user);

        ResponseEntity<UserResponse> response = userResource.registerUser(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User Registered Successful", response.getBody().getResponseMessage());
        assertEquals(1, response.getBody().getUsers().size());
    }

    @Test
    void testFetchUserById_Success() {
        User user = new User();
        user.setId(1);
        user.setFirstName("John");
        user.setLastName("Doe");

        when(userDao.findById(1)).thenReturn(Optional.of(user));

        ResponseEntity<UserResponse> response = userResource.fetchUserById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User Fetched Successful!!!", response.getBody().getResponseMessage());
        assertEquals(1, response.getBody().getUsers().size());
    }

    @Test
    void testFetchUserById_NotFound() {
        when(userDao.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<UserResponse> response = userResource.fetchUserById(1);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("User not found!!!", response.getBody().getResponseMessage());
    }

    @Test
    void testLoginUser_InvalidCredentials() {
        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setEmailId("john.doe@example.com");
        loginRequest.setPassword("wrongpassword");
        loginRequest.setRole("Customer");

        doThrow(new RuntimeException("Invalid credentials"))
                .when(authenticationManager)
                .authenticate(any());

        ResponseEntity<UserResponse> response = userResource.loginUser(loginRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid Login Credentials!!!", response.getBody().getResponseMessage());
    }

    @Test
    void testGetAllDeliveryPersons_EmptyList() {
        when(userDao.findByRole("Delivery")).thenReturn(Arrays.asList());

        ResponseEntity<UserResponse> response = userResource.getAllDeliveryPersons();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("No Delivery Person Found", response.getBody().getResponseMessage());
        assertEquals(false, response.getBody().isSuccess());
    }
}
