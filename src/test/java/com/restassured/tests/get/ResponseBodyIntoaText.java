package com.restassured.tests.get;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseBodyIntoaText {
	
	@Test
	public void saveResponseToTxtFile() throws Exception {
	
	Response response = RestAssured.given()
	.queryParam("country", "Spain")
	.when()
	.get("http://universities.hipolabs.com/search");
	
	Files.write(
	Paths.get("src/test/jsonresponse/SpainUniversities.txt"),
	response.asString().getBytes());
	
	System.out.println("Response saved successfully.");
	}

}
