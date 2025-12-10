package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pages.CustomerLoginPage;

public class CustomerLoginTest extends BaseClass
{
	CustomerLoginPage loginPage;
	@DataProvider(name="logindata")
	public Object[][] loginCredentials()
	{
		return new Object [][]
				{
			{"princy","princy@123"}
				};
	}
	@BeforeClass
	public void loginSetup()
	{
		loginPage=new CustomerLoginPage(driver);
	}
	@Test(dataProvider="logindata",priority=1)
	public void login_Click(String userName,String password)
	{
		System.out.println("login_click");
		loginPage.logIn(userName,password);
	}

}
