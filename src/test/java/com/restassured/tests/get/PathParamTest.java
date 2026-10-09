package com.restassured.tests.get;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PathParamTest {
	
	@Test
	public void getPostById() {
	
	Response response = RestAssured.given()
	.pathParam("id", 5)
	.when()
	.get("https://jsonplaceholder.typicode.com/posts/{id}")
	.then()
	.extract()
	.response();
	
	System.out.println("Response Body:\n" + response.asPrettyString());
	}

}
