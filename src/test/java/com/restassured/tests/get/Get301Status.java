package com.restassured.tests.get;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Get301Status {
	
	 @Test
	    public void verifyStatusCode301() {

	        int statusCode =
	                given()
	                .redirects().follow(false)
	                .when()
	                    .get("https://the-internet.herokuapp.com/status_codes/301")
	                .then()
	                    .extract()
	                    .statusCode();

	        assertEquals(statusCode, 301);
	    }
	

}
