package testWithAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import reqRespBuilder.RequestSpecFactory;
import reqRespBuilder.ResponseSpecFactory;
import requestData.CreateRequest;
import requestData.Data;
import requestData.DataUpdate;
import requestData.UpdateRequest;
import utils.ThreadLocalContext;

public class UpdateObjectWithCollection extends BaseTest
{

	@Test(groups="UpdateObj",dependsOnGroups="CreateObj")
	public void updateObject_Collection()
	{
		Data data=new Data();
		data.setYear("2025");
		data.setPrice("2300.00");
		data.setColor("Silver");
		
		
		UpdateRequest updateRequest=new UpdateRequest("Apple MacBook Pro 25",data);
		
		given()
			.spec(RequestSpecFactory.getRequestSpecBuilder())
			 .header("x-api-key",ConfigReader.getProperty("x-api-key"))
			 .pathParam("product", "laptop")
			 .pathParam("id",ThreadLocalContext.getObjectId() )
			.body(updateRequest)
			.log().all()
			.when()
			.put("/collections/{product}/objects/{id}")
			.then()
			.spec(ResponseSpecFactory.getResponseSpecBuilder())
			.log().all().extract().jsonPath().getString("id");		
		//ThreadLocalContext.setObjectId(id);
	
	
		
	}

}
