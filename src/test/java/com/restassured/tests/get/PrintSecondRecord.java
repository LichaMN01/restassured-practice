package com.restassured.tests.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PrintSecondRecord {

	@Test
	public void printSecondUniversityName() {
	
	Response response = RestAssured.given()
	.queryParam("country", "France")
	.when()
	.get("http://universities.hipolabs.com/search");
	
	String universityName = response.jsonPath()
	.getString("[1].name");
	
	Assert.assertEquals(universityName, "IÉSEG School of Management");
	
	System.out.println("Second university: " + universityName);
	}
	
}
