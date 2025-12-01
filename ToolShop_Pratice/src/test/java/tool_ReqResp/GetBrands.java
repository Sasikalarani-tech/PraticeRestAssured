package tool_ReqResp;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.List;

import base.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Post_Brand;

public class GetBrands extends BaseTest
{
	ResponseSpecification response_spec;
	RequestSpecification request_spec;
	@BeforeClass
	public void response_SetUp()
	{
		    request_spec=new RequestSpecBuilder()
		    		.setContentType(ContentType.JSON)
		    		.addHeader("accept", "application/json")
		    		.build();

			response_spec=new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
	}
	 
@Test
public void get_Brands()
{
	String response=given()
						.spec(request_spec)
						.when()
						.get("/brands")
						.then()
						.spec(response_spec)
						.extract()
						.asPrettyString();
System.out.println(response);
	
}
@Test
public void getSpeciifcBrand()
{
	List<String> ids=given()
			.spec(request_spec)
			.when()
			.get("/brands")
			.then()
			.spec(response_spec)
			.extract()
			.jsonPath().get("id");
System.out.println(ids);
for(String id_num:ids)
{
	System.out.println(id_num);
String response=given()
.spec(request_spec)
.pathParam("id", id_num)
.when()
.get("/brands/{id}")
.then()
.spec(response_spec)
.extract().asPrettyString();
System.out.println(response);
}
	
}
@DataProvider(name="id_list")
public Object[][] id() {
    return new Object[][] {
        {"tool"},
        {"brand"}
    };
}
@Test(dataProvider="id_list")
public void get_SearchByQuery(String query_Name)
{
	Response response=given()
	.spec(request_spec)
	.queryParam("q", query_Name)
	.when()
	.get("/brands")
	.then()
	.spec(response_spec)
	.extract().response();
	System.out.println(response.asString());
}
@Test
public void post_Put()
{
	//Post method
	Post_Brand post_Brand=new Post_Brand("ToolBrand","ToolBrand");
	String id=given()
	.spec(request_spec)
	.body(post_Brand)
	.log().all()
	.when()
	.post("/brands")
	.then()
	.statusCode(201)
	.log().all()
	.extract().jsonPath().get("id");
	System.out.println("Id from Post"+id);
	//Put method
	Post_Brand put_Brand=new Post_Brand("AXE_new","AXE_new");
	given()
	.spec(request_spec)
	.pathParam("id_num", id)
	.body(put_Brand)
	.log().all()
	.when()
	.put("/brands/{id_num}")
	.then()
	.spec(response_spec)
	.log().all()
	.extract().asPrettyString();
	
	//Get method
	String response=given()
			.spec(request_spec)
			.pathParam("id_get", id)
			.when()
			.get("/brands/{id_get}")
			.then()
			.spec(response_spec)
			.extract().asPrettyString();
			System.out.println(response);
	
	//System.out.println(response.asString());
}
}
