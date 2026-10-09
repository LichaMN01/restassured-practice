package com.restassured.tests.get;



import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetBookings {
	
	public static void main(String[] args) {

        Response response =
                given()
                .when()
                    .get("https://restful-booker.herokuapp.com/booking");
        
        JsonPath json = response.jsonPath();
        System.out.println("Booking IDs:");

    //    for (int i = 0; i < json.getList("bookingid").size(); i++) {
        	//System.out.println(json.getList("bookingid").get(i));
        	System.out.println("Cantidad de Booking IDs: " 
        	        + json.getList("bookingid").size());
    }
        
	}



