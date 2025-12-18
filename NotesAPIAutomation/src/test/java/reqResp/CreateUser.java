package reqResp;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.POJO_class;

public class CreateUser extends BaseTest
{
	RequestSpecification req_Spec;
	ResponseSpecification res_Spec;
	@Test
	public void createUser_Register()
	{
		String name="angel";
		String email="angel_t@gmail.com";
		String password="angel@123";
	POJO_class pojo=new POJO_class(name,email,password);

	req_Spec=new RequestSpecBuilder()
			.addHeader("content-type", "application/json")
			.addHeader("Accept", "application/json")
			.build();
	res_Spec=new ResponseSpecBuilder()
			.expectStatusCode(201)
			.build();
	Response response=given()
			.spec(req_Spec)
			.body(pojo)
			.when()
			.post("/users/register")
			.then()
			.extract().response();
	System.out.println(response.asPrettyString());
	Assert.assertEquals(response.jsonPath().get("message"), "User account created successfully", "Login not successful");
	Assert.assertNotNull(response.jsonPath().get("data.id"), "Id is null");
	Assert.assertEquals(response.jsonPath().get("data.name"), name,"name is not same");
	Assert.assertEquals(response.jsonPath().get("data.email"),email,"email is not same");
	//Assert.assertEquals(response.jsonPath().get("data.name"),email,"Login message");

	
}
}
