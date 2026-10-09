package com.restassured.tests.get;



import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class GetBookingXML {
	
	public static void main(String[] args) {

        Response response =
                given()
                    .contentType("application/xml")
                    .accept("application/xml")
                .when()
                    .get("https://restful-booker.herokuapp.com/booking/119");

        System.out.println(response.asPrettyString());
    }

}
