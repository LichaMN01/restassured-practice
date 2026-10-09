package com.restassured.tests.get;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import org.testng.annotations.Test;

public class MatchSchemaDataforJsonPlaceholder {
	
	@Test
	public void validateJsonSchema() {
	
	given()
	
	.when()
	.get("https://jsonplaceholder.typicode.com/posts/2")
	
	.then()
	.statusCode(200)
	.body(matchesJsonSchemaInClasspath("postSchema.json"));
	}

}
