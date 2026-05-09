package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import reqRespBuilder.RequestSpecFactory;
import reqRespBuilder.ResponseSpecFactory;
import requestData.CreateRequest;
import requestData.Data;
import utils.ThreadLocalContext;

public class CreateObjectMultiple extends BaseTest
{
	@DataProvider(name="TestData",parallel=true)
	public Object[][] getData()
	{
		Data data=new Data();
			data.setYear("2020");
			data.setPrice("1840.99");
			data.setCpuModel("Intel Core");
			data.setHardDisk("1.2TB");
		CreateRequest createRequest1=new CreateRequest("Apple MacBook Pro 16",data);
		Data data1=new Data();
			data1.setYear("2020");
			data1.setPrice("1900");
			data1.setCpuModel("Intel Core");
			data1.setHardDisk("1.5TB");
		CreateRequest createRequest2=new CreateRequest("Samsung S20",data1);
		return new Object[][]
		{
			{createRequest1},
			{createRequest2},
			
				};
	}
	@Test(dataProvider="TestData")
	public void createObject(CreateRequest request)
	{

		String id=given()
					.spec(RequestSpecFactory.getRequestSpecBuilder())
					.body(request)
				 .when()
				 	.post("/objects")
				 .then()
				 	.spec(ResponseSpecFactory.getResponseSpecBuilder())
				 	.log().all().extract().jsonPath().getString("id");
		ThreadLocalContext.setObjectId(id);
		System.out.println(ThreadLocalContext.getObjectId());
	
	}

}
