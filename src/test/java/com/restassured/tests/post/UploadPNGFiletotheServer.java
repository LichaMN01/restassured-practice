package com.restassured.tests.post;

import java.io.File;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UploadPNGFiletotheServer {
	
	@Test
	public void uploadFile() {
		
		
	
	Response response = RestAssured
	.given()
	.multiPart("purpose", "dispute_evidence")
	.multiPart("file",
	new File("src/test/resources/logo.png"))
	.auth()
    .basic("test", "")
	.when()
	.post("https://files.stripe.com/v1/files");
	
	response.prettyPrint();
	
	Assert.assertEquals(response.getStatusCode(), 200);
	}

}
