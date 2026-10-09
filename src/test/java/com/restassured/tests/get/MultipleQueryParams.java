package com.restassured.tests.get;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class MultipleQueryParams {

	@Test
	public void getUsersWithQueryParams() {
		
		Response response =
		RestAssured.given()
		.queryParam("page", 2)
		.queryParam("id", 5)
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.extract()
		.response();
		
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Body:\n" + response.asPrettyString());
		}
}
