package testWithAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import io.restassured.path.json.JsonPath;
import reqRespBuilder.RequestSpecFactory;
import reqRespBuilder.ResponseSpecFactory;

public class GetCollectionObjects extends BaseTest
{
	@Test
	public void getObjects()
	{
JsonPath response_Json=given()
		 .spec(RequestSpecFactory.getRequestSpecBuilder())
		 .header("x-api-key",ConfigReader.getProperty("x-api-key"))
		 .pathParam("product", "laptop")
		 .log().all()
		 .when()
		 .get("/collections/{product}/objects")
		 .then()
		 .spec(ResponseSpecFactory.getResponseSpecBuilder())
		 .log().all()
		 .extract( ).jsonPath();
System.out.println(response_Json);
		
	
	
		
		 
	}

}
