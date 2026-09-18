package com.example.api.client;

import com.example.api.config.RequestSpecConfig;
import com.example.api.models.UserRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    private final RequestSpecification requestSpec;

    public UserApiClient() {
        this.requestSpec =
                RequestSpecConfig.defaultRequestSpec();
    }

    public Response getUser(int userId) {

        return given()
                .spec(requestSpec)
                .pathParam("id", userId)
                .when()
                .get("/users/{id}");
    }

    public Response getUserByUsername(String username) {

        return given()
                .spec(requestSpec)
                .queryParam("username", username)
                .when()
                .get("/users");
    }

    public Response createUser(UserRequest request) {

        return given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/users");
    }
}