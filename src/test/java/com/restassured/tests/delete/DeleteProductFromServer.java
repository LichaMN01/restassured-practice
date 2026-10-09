package com.restassured.tests.delete;


import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProductFromServer {
	@Test
	public void deleteProduct() {
	
	Response response = RestAssured.given()
	.when()
	.delete("https://api.restful-api.dev/objects/ff808181a09d98f701a10c2579cc7d9a");
	
	Assert.assertEquals(response.getStatusCode(), 200);
	}

}
