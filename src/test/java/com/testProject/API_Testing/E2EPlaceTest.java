package com.testProject.API_Testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class E2EPlaceTest extends PayLoad{
	
	public String name;
	public String contactNo;
	public String address;
	public JsonPath js;
	public final String key = "qaclick123";
	public String place_id;
	public String getJsonValue(String res, String path) {
		return new JsonPath(res).get(path).toString();
	}
	
	@Test
	public void addPlaceTest() {
		
		name = "testHouse";
		contactNo = "(+91) 78504263053";
		address = "221 B Baker Street";
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String addPlaceRes = given().queryParam("key", key)
									.body(addPlaceBody(name, contactNo, address)).
							 when()
							 		.post("/maps/api/place/add/json").
							 then()
							 		.assertThat().statusCode(200)
							 		.body("scope", equalTo("APP"))
							 		.header("Server", "Apache/2.4.52 (Ubuntu)")
							 		.extract()
							 		.response()
							 		.body()
							 		.asString();
		
		
		place_id = getJsonValue(addPlaceRes, "place_id");
		System.out.println(place_id);
		
		String getPlaceRes =  given()
				  					.queryParam("key", key)
				  					.queryParam("place_id", place_id).	  
				  			  when()
				  			  		.get("/maps/api/place/get/json").
				  			  then()
				  			  		.assertThat()
				  			  		.statusCode(200)
				  			  		.extract()
				  			  		.response()
				  			  		.asString();
		

		System.out.println(getJsonValue(getPlaceRes, "location.latitude"));
		
		Assert.assertEquals(getJsonValue(getPlaceRes, "name"), name);
		Assert.assertEquals(getJsonValue(getPlaceRes, "phone_number"), contactNo);
		Assert.assertEquals(getJsonValue(getPlaceRes, "address"), address);
		
		address = "DC 500 Parker Street";
		
		
		String updatePlaceRes = given()
									.queryParam("key", key)
									.body(getUpdateJson(place_id, address, key)).
							 when()
							 		.post("/maps/api/place/update/json").
							 then()
							 		.assertThat().statusCode(200)
							 		.log().body()
							 		.extract()
							 		.response()
							 		.asString();
		
		System.out.println(updatePlaceRes);
		
		
		
		
	}
	
//	@Test
//	public void updatePlaceTest() {
//		
//		RestAssured.baseURI = "https://rahulshettyacademy.com";
//		
//		
//		
//		
////		String getPlaceRes =  given()
////									.queryParam("key", key)
////									.queryParam("place_id", place_id).	  
////							  when()
////							  		.get("/maps/api/place/get/json").
////							  then()
////							  		.assertThat()
////							  		.statusCode(200)
////							  		.extract()
////							  		.response()
////							  		.asString();
//		
//	}
//
}
