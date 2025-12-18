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



public class GetProfile extends BaseTest
{
	
	RequestSpecification req_Spec;
	ResponseSpecification res_Spec;
	@Test
	public void GetProfileUser()
	{
	String email="princy_p@gmail.com";
	String password="princy@123";
	POJO_class pojo=new POJO_class(email,password);

	req_Spec=new RequestSpecBuilder()
			.addHeader("content-type", "application/json")
			.addHeader("Accept", "application/json")
			.build();
	res_Spec=new ResponseSpecBuilder()
			.expectStatusCode(200)
			.build();
	String response=given()
			.spec(req_Spec)
			.body(pojo)
			.when()
			.post("/users/login")
			.then()
			.extract().jsonPath().get("data.token");
	System.out.println(response);
	Response response_String=given()
	.spec(req_Spec)
	.header("x-auth-token", response)
	.when()
	.get("/users/profile")
	.then()
	.extract().response();
	System.out.println(response_String.asPrettyString());
}


}
