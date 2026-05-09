package testWithAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import reqRespBuilder.RequestSpecFactory;
import reqRespBuilder.ResponseSpecFactory;
import requestData.CreateRequest;
import requestData.Data;
import utils.ThreadLocalContext;

public class DeleteObjectWithCollection extends BaseTest
{
	@Test(dependsOnGroups="UpdateObj")
	public void deleteObject_Collection()
	{
		
		String msg=given()
			.spec(RequestSpecFactory.getRequestSpecBuilder())
			 .header("x-api-key",ConfigReader.getProperty("x-api-key"))
			 .pathParam("product", "laptop")
			 .pathParam("id",ThreadLocalContext.getObjectId() )
			.when()
			.delete("/collections/{product}/objects/{id}")
			.then()
			.spec(ResponseSpecFactory.getResponseSpecBuilder())
			.log().all().extract().jsonPath().getString("message");		
		System.out.println(msg);
	
	
		
	}

}
