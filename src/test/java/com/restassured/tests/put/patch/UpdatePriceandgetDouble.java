package com.restassured.tests.put.patch;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdatePriceandgetDouble {
	
	@Test
	public void updateProductPrice() {

	    String body = """
	    {
	        "name": "Dell 15",
	        "data": {
	            "price": 4000.99
	        }
	    }
	    """;

	    Response response = RestAssured.given()
	            .header("Content-Type", "application/json")
	            .pathParam("id", "ff808181a09d98f701a10c2579cc7d9a")
	            .body(body)
	    .when()
	            .put("https://api.restful-api.dev/objects/{id}");
	    
	    Assert.assertEquals(response.getStatusCode(), 200);
	    Assert.assertEquals(
	    		response.jsonPath().getDouble("data.price"),
	    		4000.99
	    		);

	    System.out.println(response.asPrettyString());

	    Double updatedPrice = response.jsonPath().getDouble("data.price");

	    System.out.println("Updated Price: " + updatedPrice);
	}

}
