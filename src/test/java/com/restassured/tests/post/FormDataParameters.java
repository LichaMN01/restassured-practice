package com.restassured.tests.post;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FormDataParameters {
	
	@Test
	public void createCustomer() {
	
	Response response = RestAssured
	.given()
	.contentType("application/x-www-form-urlencoded")
	.auth()
	.basic("test", "")
	.contentType("application/x-www-form-urlencoded")
	.formParam("name", "Lisandro")
	.formParam("email", "lisandro@test.com")
	.formParam("description", "Cliente de prueba")
	.when()
	.post("https://api.stripe.com/v1/customers");
	
	response.prettyPrint();
	
	Assert.assertEquals(response.getStatusCode(), 200);
	

}
}
