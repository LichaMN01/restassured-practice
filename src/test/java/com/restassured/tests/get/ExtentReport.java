package com.restassured.tests.get;

import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ExtentReport {
	
	@Test
	public void getUniversities() {
	
	ExtentSparkReporter spark =
	new ExtentSparkReporter("ExtentReport.html");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(spark);
	
	ExtentTest test =
	extent.createTest("USA Universities");
	
	Response response = RestAssured
	.given()
	.queryParam("country", "United States")
	.when()
	.get("http://universities.hipolabs.com/search");
	
	List<String> names =
	response.jsonPath().getList("name");
	
	test.info("Total universities: " + names.size());
	
	for (String name : names) {
	test.info(name);
	}
	
	extent.flush();
	}

}
