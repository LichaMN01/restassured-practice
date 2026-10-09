package com.restassured.tests.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiKey {
	
	@Test
	public void verifyApiKeyAuthentication() {
	
	Response response = RestAssured
	.given()
	.queryParam("q", "chennai")
	.queryParam("appid", "9ee04ad950a675b723b4f4788c595c1f")
	.when()
	.get("https://api.openweathermap.org/data/2.5/weather");
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	System.out.println(response.asPrettyString());
	

}
}