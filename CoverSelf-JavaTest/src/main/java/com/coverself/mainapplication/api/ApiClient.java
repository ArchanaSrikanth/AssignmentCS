package com.coverself.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

    private static final String BASE_URL = "https://retoolapi.dev/L570MW/order";

    public static Response get(String path) {
        return RestAssured.get(BASE_URL + path);
    }
}
