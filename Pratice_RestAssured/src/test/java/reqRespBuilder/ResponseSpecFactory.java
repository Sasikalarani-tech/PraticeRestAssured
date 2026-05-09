package reqRespBuilder;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecFactory 
{
	public static ResponseSpecification getResponseSpecBuilder()
	{
		return new ResponseSpecBuilder()
				.expectStatusCode(200)
				.build();
	}

}
