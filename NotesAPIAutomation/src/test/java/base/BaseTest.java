package base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest
{
	@BeforeClass
	public void baseSetup()
	{
		RestAssured.baseURI="https://practice.expandtesting.com/notes/api";
	}

}
