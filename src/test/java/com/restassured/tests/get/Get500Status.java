package com.restassured.tests.get;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Get500Status {

	@Test
    public void verifyStatusCode500() {

        int statusCode =
                given()
                .when()
                    .get("https://the-internet.herokuapp.com/status_codes/500")
                .then()
                    .extract()
                    .statusCode();

        assertEquals(statusCode, 500);
	}
}
