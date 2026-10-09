package com.restassured.tests.post;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class PostRequestSuccessResponse {
	
	@Test
	public void createProduct() {

	    String body = """
	    {
	        "name": "Dell 15"
	    }
	    """;

	    Response response = RestAssured.given()
	            .header("Content-Type", "application/json")
	            .body(body)
	    .when()
	            .post("https://api.restful-api.dev/objects");
	    
	    System.out.println("Status Code: " + response.getStatusCode());
	    System.out.println("Response:\n" + response.asPrettyString());
	}

}
