package testWithAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import reqRespBuilder.RequestSpecFactory;
import reqRespBuilder.ResponseSpecFactory;
import requestData.ResgisterData;

public class RegsiterUser extends BaseTest
{
	ResgisterData regsiterData;
	
	@Test
	public void regsiterUser()
	{
		regsiterData=new ResgisterData("mathew@example.com","password123","Mathew");
		 given()
		      	.spec(RequestSpecFactory.getRequestSpecBuilder())
		      	.header("x-api-key",ConfigReader.getProperty("x-api-key"))
		      	.body(regsiterData)
		     	.log().all().
		 when()
		 		.post("/register").
		 then()
		 		.spec(ResponseSpecFactory.getResponseSpecBuilder())
		 		.log().all();
		
	}

}
