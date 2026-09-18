package com.example.api.steps;

import com.example.api.client.UserApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import com.example.api.models.UserResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserStepDefinitions {

    private final UserApiClient userApiClient =
            new UserApiClient();

    private int userId;
    private Response response;

    @Given("I have a user with ID {int}")
    public void iHaveAUserIdOf(int userId) {
        this.userId = userId;
    }

    @When("I send a GET request for the user")
    public void iSendAGetRequestForTheUser() {
        response = userApiClient.getUser(userId);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatus) {
        assertEquals(
                expectedStatus,
                response.getStatusCode()
        );
    }

    @Then("the user name should be {string}")
    public void theUserNameShouldBe(String expectedName) {

        UserResponse user =
                response.as(UserResponse.class);

        assertEquals(
                expectedName,
                user.getName()
        );
    }
}