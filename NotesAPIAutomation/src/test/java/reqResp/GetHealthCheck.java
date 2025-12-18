package reqResp;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.ResponseSpecBuilder;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class GetHealthCheck extends BaseTest
{
	RequestSpecification req_Spec;
	ResponseSpecification res_Spec;
	@Test
	public void getHealth()
	{
		//Map<String,String> cookie=new HashMap<>();
		//cookie.put("sess","eyJmbGFzaCI6e319");
		//cookie.put("sess.sig","tdt42nQZiQvICqmrvHQ1_16fHk0");
		req_Spec=new RequestSpecBuilder()
				.addHeader("content-type", "application/json")
				.addHeader("Accept", "application/json")
				.build();
		res_Spec=new ResponseSpecBuilder()
				.expectStatusCode(200)
				.build();
		Response response=given()
				.spec(req_Spec)
				.when()
				.get("/health-check")
				.then()
				.extract().response();
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.jsonPath().get("message"),"Notes API is Running");
		Assert.assertEquals(response.jsonPath().get("success"),true);
		
	}
	
	

}
