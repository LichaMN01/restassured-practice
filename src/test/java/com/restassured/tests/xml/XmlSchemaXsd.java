package com.restassured.tests.xml;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsd;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class XmlSchemaXsd {
	
	@Test
	public void validateXmlSchema() {
	
		String xsdString =
			    "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">" +
			    "<xs:element name=\"booking\">" +
			    "<xs:complexType>" +
			    "<xs:sequence>" +
			    "<xs:element name=\"firstname\" type=\"xs:string\"/>" +
			    "<xs:element name=\"lastname\" type=\"xs:string\"/>" +
			    "<xs:element name=\"totalprice\" type=\"xs:int\"/>" +
			    "<xs:element name=\"depositpaid\" type=\"xs:boolean\"/>" +
			    "<xs:element name=\"bookingdates\">" +
			        "<xs:complexType>" +
			            "<xs:sequence>" +
			                "<xs:element name=\"checkin\" type=\"xs:string\"/>" +
			                "<xs:element name=\"checkout\" type=\"xs:string\"/>" +
			            "</xs:sequence>" +
			        "</xs:complexType>" +
			    "</xs:element>" +
			//    "<xs:element name=\"additionalneeds\" type=\"xs:string\"/>" +
			    "</xs:sequence>" +
			    "</xs:complexType>" +
			    "</xs:element>" +
			    "</xs:schema>";
		
		System.out.println(xsdString);	
	
	Response response =given()
	.accept("application/xml")
	.when()
	.get("https://restful-booker.herokuapp.com/booking/2");
	
	response.then()	
    .body(matchesXsd(xsdString));
	}

}
