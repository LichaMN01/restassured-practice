package com.restassured.tests.get;


import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;


public class BasicAuthTest {

    @Test
    public void verifyBasicAuthentication() {

        
                given()
                    .auth()
                    .basic("postman", "password")
                .when()
                    .get("https://postman-echo.com/basic-auth")
                .then()
                    .statusCode(200)
                    .body("authenticated", equalTo(true));
    }
}