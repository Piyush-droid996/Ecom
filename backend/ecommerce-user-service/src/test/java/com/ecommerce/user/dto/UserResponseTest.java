package com.ecommerce.user.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ecommerce.user.model.User;

class UserResponseTest {

    @Test
    void testSettersAndGetters() {
        UserResponse response = new UserResponse();

        // Prepare test data
        User user1 = new User();
        user1.setId(1);
        user1.setEmailId("user1@example.com");

        User user2 = new User();
        user2.setId(2);
        user2.setEmailId("user2@example.com");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        String testJwtToken = "test-jwt-token";

        // Set values
        response.setUsers(userList);
        response.setJwtToken(testJwtToken);
        response.setResponseMessage("Success");
        response.setSuccess(true);

        // Test getters
        assertEquals(userList, response.getUsers(), "The user list should match the set value.");
        assertEquals(testJwtToken, response.getJwtToken(), "The JWT token should match the set value.");
        assertEquals("Success", response.getResponseMessage(), "The response message should match the set value.");
        assertTrue(response.isSuccess(), "The success flag should be true.");
    }

    @Test
    void testDefaultValues() {
        UserResponse response = new UserResponse();

        // Verify default values
        assertEquals(0, response.getUsers().size(), "The default user list should be empty.");
        assertEquals(null, response.getJwtToken(), "The default JWT token should be null.");
        assertEquals(null, response.getResponseMessage(), "The default response message should be null.");
        assertEquals(false, response.isSuccess(), "The default success flag should be false.");
    }

    @Test
    void testSetUsers() {
        UserResponse response = new UserResponse();

        // Prepare test data
        User user = new User();
        user.setId(1);
        user.setEmailId("test@example.com");

        List<User> users = new ArrayList<>();
        users.add(user);

        // Set users
        response.setUsers(users);

        // Verify
        assertEquals(1, response.getUsers().size(), "The user list size should be 1.");
        assertEquals("test@example.com", response.getUsers().get(0).getEmailId(), "The email ID should match.");
    }
}
