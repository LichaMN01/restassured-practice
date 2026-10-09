package com.restassured.tests.get;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Get404Status {

	   @Test
	    public void verifyStatusCode404() {

	        int statusCode =
	                given()
	                .when()
	                    .get("https://the-internet.herokuapp.com/status_codes/404")
	                .then()
	                    .extract()
	                    .statusCode();

	        assertEquals(statusCode, 404);
	    }
}
