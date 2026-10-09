package com.restassured.tests.post;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.datafaker.Faker;

public class FakerForDynamicDataGeneration {
	
	@Test
	public void createUserUsingFaker() {
	
	Faker faker = new Faker();
	
	String name = faker.name().fullName();
	String email = faker.internet().emailAddress();
	
    
	String body = "{\n"
			+ "\"name\":\"" + name + "\",\n"
			+ "\"email\":\"" + email + "\",\n"
			+ "\"gender\":\"male\",\n"
			+ "\"status\":\"active\"\n"
			+ "}";
			
	         Response response = given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer ee203e1d970ea464e194917cecef8634dc398428970893bf4d4fa5982d503374")
			.body(body)
			
			.when()
			.post("https://gorest.co.in/public/v2/users")
			
			.then()
			.extract()
			.response();
			
			response.prettyPrint();
	
	Assert.assertEquals(response.getStatusCode(), 201);
	
	Assert.assertEquals(
			response.jsonPath().getString("name"),
			name);
	Assert.assertEquals(
			response.jsonPath().getString("email"),
			email);
	Assert.assertEquals(
			response.jsonPath().getString("status"),
			"active");
}
}