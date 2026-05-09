package testWithAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import io.restassured.path.json.JsonPath;
import reqRespBuilder.RequestSpecFactory;
import reqRespBuilder.ResponseSpecFactory;

public class GetCollections extends BaseTest
{
	@Test
	public void getCollections()
	{
		JsonPath response_Json=given()
				 .accept("application/json")
				 .spec(RequestSpecFactory.getRequestSpecBuilder())
				 .header("x-api-key",ConfigReader.getProperty("x-api-key"))
				 .log().all()
				 .when()
				 .get("/collections")
				 .then()
				 .spec(ResponseSpecFactory.getResponseSpecBuilder())
				 .log().all()
				 .extract( ).jsonPath();
				
				String id=response_Json.getString("id");
				
	}

}
