package tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import reqRespBuilder.RequestSpecFactory;
import reqRespBuilder.ResponseSpecFactory;

import static org.hamcrest.Matchers.lessThan;

public class GetObjectsById extends BaseTest
{



	@Test
	public void getObjectsById()
	{
	String id=given()
		 .accept("application/json")
		 .spec(RequestSpecFactory.getRequestSpecBuilder())
		 .log().all()
		 .when()
		 .get("/objects")
		 .then()
		 .spec(ResponseSpecFactory.getResponseSpecBuilder())
		 .log().all()
		 .extract( ).jsonPath().getString("find{it.name=='Apple iPhone 12 Pro Max'}.id");
		
	
		JsonPath response_Json=given()
				 .accept("application/json")
				.pathParam("id",id)
				 .spec(RequestSpecFactory.getRequestSpecBuilder())
				 .log().all()
				 .when()
				 .get("/objects/{id}")
				 .then()
				 .spec(ResponseSpecFactory.getResponseSpecBuilder())
				 .log().all()
				 .extract( ).jsonPath();
		
		System.out.println(response_Json);
		String color=response_Json.getString("data.color");
		Assert.assertEquals(color,"Cloudy White");
		System.out.println(color);
	
		
		 
	}


}
