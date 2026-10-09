package com.restassured.tests.put.patch;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UsingPatchToUpdateName {
	
	@Test
	public void updateProductName() {

	    String body = """
	    {
	        "name": "Dell Inspiron 15"
	    }
	    """;

	    Response response = RestAssured.given()
	            .header("Content-Type", "application/json")
	            .pathParam("id", "ff808181a09d98f701a10c2579cc7d9a")
	            .body(body)
	    .when()
	            .patch("https://api.restful-api.dev/objects/{id}");

	    Assert.assertEquals(response.getStatusCode(), 200);

	    Assert.assertEquals(
	            response.jsonPath().getString("name"),
	            "Dell Inspiron 15"
	    );

	    System.out.println(response.asPrettyString());
	}

}
