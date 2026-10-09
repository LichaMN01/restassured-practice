package com.restassured.tests.post;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.restassured.response.Response;

public class DownloadFile {
	
	@Test
	public void verifyFileDownload() throws Exception {
	
	Response response =
	given()
	.when()
	.get("https://the-internet.herokuapp.com/download/customer-file.png");
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
    byte[] fileBytes = response.asByteArray();
	
	Path filePath = Paths.get(
	"src/test/resources/downloads/customer-file.png");
	
	Files.createDirectories(filePath.getParent());
	
	Files.write(filePath, fileBytes);
	
	File downloadedFile = filePath.toFile();
	
	Assert.assertTrue(downloadedFile.exists());
	Assert.assertTrue(downloadedFile.length() > 0);
	
	String body = response.getBody().asString();
	
	System.out.println(body);
	
	Assert.assertFalse(body.isEmpty(),
	"El archivo descargado está vacío");
	}

}
