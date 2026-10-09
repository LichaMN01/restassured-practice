package com.restassured.tests.post;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MultipartUpload {

	
	@Test
	public void verifyFileUpload() {
	
	File file = new File("src/test/resources/logo.png");
	
	Response response =
	RestAssured.given()
	.multiPart("file", file)
	.when()
	.post("https://the-internet.herokuapp.com/upload");
	
	System.out.println("Status Code: " + response.getStatusCode());
	System.out.println(response.asString());
	
	Assert.assertEquals(response.getStatusCode(), 200);
	}
	}

