 package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pages.HomePage;

public class HomePageTest extends BaseClass
{
	HomePage HomePage;
@Test
public void homePageSetUp()
{
HomePage=new HomePage(driver);
System.out.println(driver);
}
@Test
public void register()
{
	
	HomePage.register();
}
}
