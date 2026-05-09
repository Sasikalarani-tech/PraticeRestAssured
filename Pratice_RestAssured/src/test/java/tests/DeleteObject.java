package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import reqRespBuilder.RequestSpecFactory;
import reqRespBuilder.ResponseSpecFactory;

import static io.restassured.RestAssured.given;

public class DeleteObject extends BaseTest
{
	CreateObject create;
	@Test(dependsOnMethods="tests.CreateObject.createObject")
	public void deleteObject()
	{

		create=new CreateObject();
		given().spec(RequestSpecFactory.getRequestSpecBuilder())
		.pathParam("id", CreateObject.id)
		.when()
		.delete("/objects/{id}")
		.then()
		.spec(ResponseSpecFactory.getResponseSpecBuilder())
		.log().all();
		
	}

}
