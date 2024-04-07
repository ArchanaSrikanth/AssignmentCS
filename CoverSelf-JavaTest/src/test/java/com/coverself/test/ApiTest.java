package com.coverself.tests;

import com.coverself.api.ApiClient;
import com.coverself.utils.FileUtil;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiTest {

    @Test
    public void testApi() {

        Response response = ApiClient.get("https://retoolapi.dev/L570MW/order");


        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);


        String responseBody = response.getBody().asString();

        assertTrue(responseBody.contains("expectedContent"));


        FileUtil.saveToFile(responseBody, "src/test/resources/orders.json");
    }
}
