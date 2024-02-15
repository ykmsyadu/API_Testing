package com.testProject.API_Testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class E2EBookAPITest {
	
	public JsonPath getJson(String res) {
		return new JsonPath(res);
	}
	
	String id;
	String author = "Yadu";
	@Test(priority = 1)
	public void addBookTest() {
		RestAssured.baseURI = "http://216.10.245.166";
		
			String AddBookResponse = given()
									  	.headers("Content-Type","application/json")
									  	.body(PayLoad.getBookBody("Test_Accademy", author)).
									 when()
									 	.post("/Library/Addbook.php").
									 then()
									    .assertThat()
									    .statusCode(200)
									    .body("Msg", equalTo("successfully added"))
									    .extract()
									    .response()
									    .body()
									    .asString();
			
			id = getJson(AddBookResponse).get("ID");
			
			
	}
	
	@Test(priority = 2)
	public void getBookTest() {
		
		System.out.println(id);
		
		String getBookRes = given()
								  .headers("Content-Type","application/json")
								  .queryParam("ID", id).
							when()
								 .get("/Library/GetBook.php").
							then()
								 .assertThat()
								 .statusCode(200)
								 .extract()
								 .response()
								 .body()
								 .asString();
		
		System.out.println(getBookRes);
		
		String actauthor = getJson(getBookRes).get("[0].author");

		Assert.assertEquals(actauthor, author);
		
		
	}
	
	@Test(priority = 3)
	public void deleteBookTest() {
		
		String DelBookResponse = given()
								  	.headers("Content-Type","application/json")
								  	.body("{\r\n"
								  			+ "\r\n"
								  			+ "\"ID\":\""+id+"\"\r\n"
								  			+ "\r\n"
								  			+ "}").
								 when()
								 	.post("/Library/DeleteBook.php").
								 then()
								    .assertThat()
								    .statusCode(200)
								    .body("msg", equalTo("book is successfully deleted"))
								    .extract()
								    .response()
								    .body()
								    .asString();
		
		System.out.println(DelBookResponse);
		
		System.out.println("Test Success");
		
							
	}
}
