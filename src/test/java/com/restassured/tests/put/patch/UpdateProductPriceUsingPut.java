package com.restassured.tests.put.patch;


import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProductPriceUsingPut {
	
	@Test
	public void updateProductPrice() {

	    String body = """
	    {
	        "name": "Dell 15",
	        "data": {
	            "price": 3000.99
	        }
	    }
	    """;

	    Response response = RestAssured.given()
	            .header("Content-Type", "application/json")
	            .body(body)
	    .when()
	            .put("https://api.restful-api.dev/objects/ff808181a09d98f701a10c2579cc7d9a");

	    Assert.assertEquals(response.getStatusCode(), 200);

	    System.out.println(response.asPrettyString());
	}

}
