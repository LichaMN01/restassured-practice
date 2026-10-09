package com.restassured.tests.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifyUsaPopulation {
	
	@Test
	public void verifyPopulation() {
	
		Response response = RestAssured.given()
				.queryParam("cube", "acs_yg_total_population_5")
				.queryParam("drilldowns", "Nation,Year")
				.queryParam("measures", "Population")
				.queryParam("include", "Year:2016")
				.when()
				.get("https://api.datausa.io/tesseract/data.jsonrecords");
	
		double population = response.jsonPath()
				.getDouble("data[0].Population");
				
				System.out.println(population);
	
	Assert.assertEquals(population, 3.1855818E8);
	}

}
