package com.restassured.tests.get;


import java.io.IOException;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ResponseBodyIntoaJson {

	@Test
	
	public void saveResponseToJsonFile() throws IOException {
		
		Response response = RestAssured.given()
		.queryParam("country", "Uganda")
		.when()
		.get("http://universities.hipolabs.com/search");
		
		Files.write(
				Paths.get("src/test/jsonresponse/UgandaUniversities.json"),
				response.asString().getBytes());
		
		System.out.println(
				Paths.get("src/test/jsonresponse/UgandaUniversities.json").toAbsolutePath()
				);
				
				int totalUniversities = response.jsonPath()
				.getList("$")
				.size();
				
				System.out.println("Total universities: " + totalUniversities);
				}
				}
		

