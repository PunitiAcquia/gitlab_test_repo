package com.gitlab.api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Tests {
    
	@Test
	public void getAPI() {
		// set up base URI
		RestAssured.baseURI = "http://localhost:8080/v1/fetch-album";
		//get response
		Response response = RestAssured.given().when().get();
		//check response 
		System.out.println("Response => "+ response.getBody().asString());
		System.out.println("Time => " + response.getTime());
		System.out.println("Cookies => " + response.getCookies());
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json; charset=utf-8");
	}
	@Test
	public void postAPI() {
		RestAssured.baseURI="https://reqres.in/api/users";
		String body = "{\\n\"\n"
				+ "				+ \"    \\\"name\\\": \\\"puniti\\\",\\n\"\n"
				+ "				+ \"    \\\"job\\\": \\\"QE\\\"\\n\"\n"
				+ "				+ \"}";
		RestAssured.given().body(body).post().then().log().all().assertThat().statusCode(201);
		
	}
}
