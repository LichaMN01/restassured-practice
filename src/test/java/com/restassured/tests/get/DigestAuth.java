package com.restassured.tests.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DigestAuth {
	
	@Test
	public void verifyDigestAuthentication() {
	
	Response response = RestAssured
	.given()
	.auth()
	.digest("postman", "password")
	.when()
	.get("https://postman-echo.com/digest-auth");
	
	// Verificar status code
	Assert.assertEquals(response.getStatusCode(), 200);
	
	// Verificar response body
	boolean authenticated =
	response.jsonPath().getBoolean("authenticated");
	
	Assert.assertTrue(authenticated);
	
	System.out.println(response.asPrettyString());
	}

}
