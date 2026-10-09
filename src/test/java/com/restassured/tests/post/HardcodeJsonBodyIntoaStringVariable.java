package com.restassured.tests.post;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HardcodeJsonBodyIntoaStringVariable {
	
	@Test
	public void createObject() {
	
	String body = """
	{
	"name": "Apple MacBook Pro 16",
	"data": {
	"year": 2019,
	"price": 1849.99,
	"CPU model": "Intel Core i9",
	"Hard disk size": "1 TB"
	}
	}
	""";
	
	Response response = RestAssured
	.given()
	.header("Content-Type", "application/json")
	.body(body)
	.when()
	.post("https://api.restful-api.dev/objects");
	
	response.prettyPrint();
	
	Assert.assertEquals(response.getStatusCode(), 200);
	}

}
