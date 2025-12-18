package reqResp;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import base.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.POJO_class;

public class CreateUser_Negative extends BaseTest
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
	given()
			.spec(req_Spec)
			.body(pojo)
			.when()
			.post("/users/register")
			.then()
			.body("success", equalTo(false))
			.body("status", equalTo(409))
			.body("message",equalTo("An account already exists with the same email address"));
}

}
