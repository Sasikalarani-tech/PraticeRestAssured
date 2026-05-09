package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import reqRespBuilder.RequestSpecFactory;
import reqRespBuilder.ResponseSpecFactory;
import requestData.CreateRequest;
import requestData.Data;

import static io.restassured.RestAssured.given;

public class CreateObject extends BaseTest
{
public static String id;
	@Test
	public void createObject()
	{
		Data data=new Data();
		data.setYear("2019");
		data.setPrice("1840.99");
		data.setCpuModel("Intel Core");
		data.setHardDisk("1.2TB");
		CreateRequest createRequest=new CreateRequest("Apple MacBook Pro 16",data);
		
		id=given()
			.spec(RequestSpecFactory.getRequestSpecBuilder())
			.body(createRequest)
			.when()
			.post("/objects")
			.then()
			.spec(ResponseSpecFactory.getResponseSpecBuilder())
			.log().all().extract().jsonPath().getString("id");		
		System.out.println(id);
	
		
	}
	@Test
	public void createObject_WithoutName()
	{
		Data data=new Data();
		data.setYear("2019");
		data.setPrice("1840.99");
		data.setCpuModel("Intel Core");
		data.setHardDisk("1.2TB");
		CreateRequest createRequest=new CreateRequest("Apple MacBook Pro 16",data);
		
		id=given()
			.spec(RequestSpecFactory.getRequestSpecBuilder())
			.body(createRequest)
			.when()
			.post("/objects")
			.then()
			.spec(ResponseSpecFactory.getResponseSpecBuilder())
			.log().all().extract().jsonPath().getString("id");		
		System.out.println(id);
	
		
	}

}
