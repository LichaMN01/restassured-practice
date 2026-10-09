package com.restassured.tests.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BearerToken {
	
	@Test
	public void verifyBearerTokenAuthentication() {
	
//	String token = "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";
	
	Response response = RestAssured
	.given()
	.header("Authorization", "Bearer " + token)
	.when()
	.get("https://api.github.com/user/repos");
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	System.out.println(response.asPrettyString());
	}

}
