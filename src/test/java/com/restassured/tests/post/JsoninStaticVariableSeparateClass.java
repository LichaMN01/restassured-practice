package com.restassured.tests.post;

import com.restassured.data.RequestBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsoninStaticVariableSeparateClass {
	
	@Test
	public void createObject() {
	
	Response response = RestAssured
	.given()
	.header("Content-Type", "application/json")
	.body(RequestBody.body)
	.when()
	.post("https://api.restful-api.dev/objects");
	
	response.prettyPrint();
	
	Assert.assertEquals(response.getStatusCode(), 200);
	}
	}


