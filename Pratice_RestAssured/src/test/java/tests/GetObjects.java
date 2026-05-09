package tests;

import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.Test;

import base.BaseTest;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import reqRespBuilder.RequestSpecFactory;
import reqRespBuilder.ResponseSpecFactory;

public class GetObjects extends BaseTest
{

	@Test
	public void getObjects()
	{
JsonPath response_Json=given()
		 .accept("application/json")
		 .spec(RequestSpecFactory.getRequestSpecBuilder())
		 .log().all()
		 .when()
		 .get("/objects")
		 .then()
		 .spec(ResponseSpecFactory.getResponseSpecBuilder())
		 .log().all()
		 .extract( ).jsonPath();
		
		String id=response_Json.getString("id");
		
		//To return name of the 3rd id(id=3)
		String name=response_Json.getString("find{it.id=='3'}.name");
		System.out.println(name);
		System.out.println(id);
		//To return color inside data.color
		String color=response_Json.getString("find{it.id=='3'}.data.color");
		System.out.println(color);
		
		 
	}

}
