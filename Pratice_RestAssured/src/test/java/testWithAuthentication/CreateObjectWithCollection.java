package testWithAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import reqRespBuilder.RequestSpecFactory;
import reqRespBuilder.ResponseSpecFactory;
import requestData.CreateRequest;
import requestData.Data;
import utils.ThreadLocalContext;

public class CreateObjectWithCollection extends BaseTest
{
	@Description("Create Object with Authentication")
	@Story("CreateObject")
	@Test(groups="CreateObj")
	public void createObject_Collection()
	{
		Data data=new Data();
		data.setYear("2019");
		data.setPrice("1840.99");
		data.setCpuModel("Intel Core");
		data.setHardDisk("1.2TB");
		CreateRequest createRequest=new CreateRequest("Apple MacBook Pro 16",data);
		
		Response response=given()
			.spec(RequestSpecFactory.getRequestSpecBuilder())
			 .header("x-api-key",ConfigReader.getProperty("x-api-key"))
			 .pathParam("product", "laptop")
			.body(createRequest)
			.when()
			.post("/collections/{product}/objects")
			.then()
			.spec(ResponseSpecFactory.getResponseSpecBuilder())
			.log().all().extract().response();
		String id=response.jsonPath().getString("id");
		ThreadLocalContext.setObjectId(id);
		Allure.addAttachment("CreateObjectWithCollection Response:",response.getBody().asPrettyString());
	System.out.println(ThreadLocalContext.getObjectId());
	
		
	}

}
