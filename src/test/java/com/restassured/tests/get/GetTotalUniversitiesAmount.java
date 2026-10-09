package com.restassured.tests.get;

import java.util.List;
import io.restassured.filter.log.ResponseLoggingFilter;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTotalUniversitiesAmount {
	
	@Test
	public void getuniversities() {
		
		Response response = RestAssured.given()
				.queryParam("country", "United States")
				.log().all()
				//	.filter(new ResponseLoggingFilter())
        
		.when()
		.get("http://universities.hipolabs.com/search?country=United+States");
		
		
		int totalUniversities = response.jsonPath().getList("$").size();
		
		System.out.println("Total universities: " + totalUniversities);
		
		List<String> names = response.jsonPath().getList("name");
		
		for (String name : names) {
		System.out.println(name);
		}		
		
		

}

}
