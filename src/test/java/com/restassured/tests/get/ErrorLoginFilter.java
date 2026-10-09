package com.restassured.tests.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.response.Response;

public class ErrorLoginFilter {
	
	@Test
	public void verifyErrorLogging() {
	
	Response response = RestAssured.given()
	.filter(new ErrorLoggingFilter())
	.when()
	.get("http://universities.hipolabs.com/search1");
	
	System.out.println("Status Code: "
	+ response.getStatusCode());
	
	Assert.assertEquals(
	response.getStatusCode(),
	404);
	}
	}


