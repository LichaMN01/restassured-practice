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
	.auth()
	.basic("sk_test_51UNa1qH9uqRZuXfxwQxjXWrHcqevXDZdZW8D4l9X3JTPfgfQaiLWFLCaSheauA0puwAyTw0h0ORrKGa9iztwTFVj00ObsTvYld", "")
	.multiPart("purpose", "dispute_evidence")
	.multiPart("file",
	new File("src/test/resources/logo.png"))
	.when()
	.post("https://files.stripe.com/v1/files");
	
	response.prettyPrint();
	
	Assert.assertEquals(response.getStatusCode(), 200);
	}

}
