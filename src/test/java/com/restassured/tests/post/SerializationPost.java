package com.restassured.tests.post;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.pojo.Booking;
import com.restassured.pojo.BookingDates;
import com.restassured.pojo.BookingResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SerializationPost {
	
	@Test
	public void createBooking() throws Exception {
	
	BookingDates bookingDates = new BookingDates();
	bookingDates.setCheckin("2024-01-01");
	bookingDates.setCheckout("2024-01-10");
	
	Booking booking = new Booking();
	booking.setFirstname("Lisandro");
	booking.setLastname("Nunzio");
	booking.setTotalprice(1000);
	booking.setDepositpaid(true);
	booking.setBookingdates(bookingDates);
	booking.setAdditionalneeds("Breakfast");
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	String requestBody =
	objectMapper.writeValueAsString(booking);
	
	System.out.println("Request Body:");
	System.out.println(requestBody);
	
	Response response = RestAssured
			.given()
			.header("Content-Type", "application/json")
			.body(requestBody)
			.when()
			.post("https://restful-booker.herokuapp.com/booking");
			
			System.out.println("Response Body:");
			response.prettyPrint();
			
			Assert.assertEquals(response.getStatusCode(), 200);
			
			String responseBody = response.asString();

			BookingResponse bookingResponse =
			        objectMapper.readValue(
			                responseBody,
			                BookingResponse.class);
			System.out.println(
			        bookingResponse.getBookingid());
			

}
}
