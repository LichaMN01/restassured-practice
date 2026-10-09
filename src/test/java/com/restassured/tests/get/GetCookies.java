package com.restassured.tests.get;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCookies {
	
	@Test
	public void validateCookies() {
	
	Response response = RestAssured.given()
	.when()
	.get("https://postman-echo.com/cookies/set?skill=Communication");
	System.out.println(response.getHeaders());
	
	// Extraer todas las cookies
	Map<String, String> cookies = response.getCookies();
	
	System.out.println("Todas las cookies:");
	for (Map.Entry<String, String> cookie : cookies.entrySet()) {
	System.out.println(cookie.getKey() + " = " + cookie.getValue());
	}
	
	// Extraer una cookie específica
	String skillCookie = response.getCookie("skill");
	
	System.out.println("Cookie skill = " + skillCookie);
	
	// Validar valor
	Assert.assertEquals(skillCookie, "Communication");
	
	// Verificar existencia
	Assert.assertTrue(cookies.containsKey("skill"));
	}
	}


