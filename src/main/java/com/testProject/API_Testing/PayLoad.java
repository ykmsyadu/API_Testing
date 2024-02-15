package com.testProject.API_Testing;

import java.util.Random;

import com.github.javafaker.Faker;



public class PayLoad {
	
	Faker fk;
	
	public String addPlaceBody(String name, String mobileNo, String address) {
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \""+name+"\",\r\n"
				+ "  \"phone_number\": \""+mobileNo+"\",\r\n"
				+ "  \"address\": \""+address+"\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public String addPlaceBodywithData() {
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \""+getName()+"\",\r\n"
				+ "  \"phone_number\": \""+getContactNo()+"\",\r\n"
				+ "  \"address\": \""+getAddress()+"\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	
	public String getUpdateJson(String place_id, String address, String key) {
		
		return "{\r\n"
				+ "\""+place_id+"\":\"8d2573bdf6ceec0e474c5f388fa917fb\",\r\n"
				+ "\"address\":\""+address+"\",\r\n"
				+ "\"key\":\""+key+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public String getName() {
		
		return new Faker().name().fullName().toString();
	}
	
	public String getAddress() {
		
		return new Faker().address().streetAddress().toString();
	}
	
	public String getContactNo() {
		return new Faker().number().digits(10).toString();
	}
	
	public static String getJson() {
		
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 910,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}
	
	
	public static String getBookBody(String companyName, String author) {
		return "{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+companyName+"\",\r\n"
				+ "\"aisle\":"+new Random().nextInt()+",\r\n"
				+ "\"author\":\""+author+"\"\r\n"
				+ "}";
		
	}
	
	
	
}
