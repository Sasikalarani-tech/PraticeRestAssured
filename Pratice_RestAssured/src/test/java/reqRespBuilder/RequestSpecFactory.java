package reqRespBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class RequestSpecFactory 
{

	public static RequestSpecification getRequestSpecBuilder()
	{
	 return new RequestSpecBuilder()
			.addHeader("Content-Type", "application/json")
			.build();
	}

}
