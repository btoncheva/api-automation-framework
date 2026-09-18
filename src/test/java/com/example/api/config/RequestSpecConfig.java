package com.example.api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecConfig {

    public static RequestSpecification defaultRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(TestConfig.BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification authenticatedRequestSpec(String token) {

        return new RequestSpecBuilder()
                .setBaseUri(TestConfig.BASE_URL)
                .setAccept(ContentType.JSON)
                .addHeader(
                        "Authorization",
                        "Bearer " + token
                )
                .build();
    }
}