package com.restassured.tests.get;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class StatusCode {
	
	@Test
	 public void f() {
		  

	      int statusCode =
	              given()
	              .when()
	              .get("https://the-internet.herokuapp.com/status_codes/200")
	              .getStatusCode();

	      assertEquals(statusCode, 200);
		  
	  }

}

