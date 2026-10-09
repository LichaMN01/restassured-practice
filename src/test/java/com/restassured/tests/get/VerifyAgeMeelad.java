package com.restassured.tests.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifyAgeMeelad {
	
	@Test
	public void verifyAge() {
	
	Response response = RestAssured.given()
	.queryParam("name", "meelad")
	.when()
	.get("https://api.agify.io/");
	
	int age = response.jsonPath()
	.getInt("age");
	
	Assert.assertEquals(age, 35);
	
	System.out.println("Age: " + age);
	}
	

}
