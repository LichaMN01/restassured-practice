package com.restassured.tests.post;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonFileastheRequestPayload {
	
	
	
	@Test
	public void createObject() throws Exception {

		String body = Files.readString(
				Paths.get("src/test/resources/body.json"));
		
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
