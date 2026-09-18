package com.example.api.tests;

import com.example.api.models.UserResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import com.example.api.models.UserRequest;
import com.example.api.client.UserApiClient;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserApiTests {
    private final UserApiClient userApiClient = new UserApiClient();
    
    @Test
    void getUserSuccessfullyTest() {

        Response response =
                userApiClient.getUser(1);

        assertEquals(200, response.getStatusCode());

        UserResponse user =
                response.as(UserResponse.class);

        assertEquals(1, user.getId());
        assertEquals("Leanne Graham", user.getName());
    }

    @Test
    void getUserByUsernameTest() {

        Response response = userApiClient.getUserByUsername("Bret");

        assertEquals(200, response.getStatusCode());

        UserResponse[] users = response.as(UserResponse[].class);

        assertEquals(1, users.length);
        assertEquals("Bret", users[0].getUsername());
    }

    @Test
    void createUserSuccessfullyTest() {

        UserRequest request =
                new UserRequest(
                        "John Smith",
                        "johnsmith",
                        "john@example.com"
                );

        Response response =
                userApiClient.createUser(request);

        assertEquals(201, response.getStatusCode());

        UserResponse user =
                response.as(UserResponse.class);

        assertEquals("John Smith", user.getName());
        assertEquals("johnsmith", user.getUsername());
        assertEquals("john@example.com", user.getEmail());
    }



}
