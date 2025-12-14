package category_ReqResp;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Category;
import pojo.SubCategory;
public class GetCategory extends BaseTest
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
	public void get_Subcategory()
	{
		
		List<Category> category=given()
		.spec(request_spec)
		.when()
		.get("/categories/tree")
		.then()
		.spec(response_spec)
		.extract().body().jsonPath().getList("",Category.class);
		//System.out.println(response);
		for (Category cat : category) {
		    System.out.println(cat.getId());
		    System.out.println(cat.getName());
		    System.out.println(cat.getParentid());
		    System.out.println(cat.getSlug());
		    for (SubCategory  sub : cat.getSubCategory())
		    {
		    	   System.out.println(sub.getId());
				    System.out.println(sub.getName());
				    System.out.println(sub.getParentid());
				    System.out.println(sub.getSlug());
				    System.out.println(sub.getSubCategory());
		    }
		}
		
	}

}
