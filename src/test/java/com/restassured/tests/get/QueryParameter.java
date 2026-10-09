package com.restassured.tests.get;


import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class QueryParameter {
	
	public static void main(String[] args) {

		Response response = RestAssured
		.given()
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/users");
		
	//	System.out.println("Status Code: " + response.getStatusCode());
	//	System.out.println(response.getBody().asString());
		
		
		JsonPath json = response.jsonPath();

		List<String> firstNames = json.getList("data.first_name");
	
		for(String name : firstNames) {
		System.out.println(name);
		}
		
		}
	

}
