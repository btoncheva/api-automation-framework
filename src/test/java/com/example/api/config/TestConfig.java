 package com.example.api.config;

    public class TestConfig {

        private TestConfig() {
        }

        public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

        public static final String API_TOKEN = System.getenv("API_TOKEN");
}
