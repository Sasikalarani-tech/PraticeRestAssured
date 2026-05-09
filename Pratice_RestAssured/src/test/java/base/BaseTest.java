package base;

import org.testng.annotations.BeforeClass;

import config.ConfigReader;
import io.restassured.RestAssured;

public class BaseTest 
{
	@BeforeClass
	public void base_SetUp()
	{
	RestAssured.baseURI=ConfigReader.getProperty("url");
	}

}
