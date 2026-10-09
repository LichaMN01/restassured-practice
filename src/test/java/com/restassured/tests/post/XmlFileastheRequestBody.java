package com.restassured.tests.post;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class XmlFileastheRequestBody {
	
	@Test
	public void createToken() throws Exception {
		
	String body = Files.readString(
			Paths.get("src/test/resources/AuthXml.xml"));
	
	Response response = RestAssured
			.given()
			.header("Content-Type", "application/xml")
			.body(body)
			.when()
			.post("https://restful-booker.herokuapp.com/auth");
	
	response.prettyPrint();
	
	Assert.assertEquals(response.getStatusCode(), 200);
}	
}
