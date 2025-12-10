package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pages.SignUpPage;

public class SignUpTest extends BaseClass
{
SignUpPage signUpPage;
@Test(priority=1,dependsOnMethods= {"test.HomePageTest.register"})
public void signUpRegister()
{
	System.out.println("Signup Started");
	signUpPage=new SignUpPage(driver);
	signUpPage.enterFirstName();
	signUpPage.enterLastName();
	signUpPage.enterAddress();
	signUpPage.enterCity();
	signUpPage.enterState();
	signUpPage.enterphoneNumber();
	signUpPage.enterSSN();
	signUpPage.enterzipCode();
	signUpPage.enteruserName();
	signUpPage.enterpassword();
	signUpPage.enterconfirmPassword();
	signUpPage.clickRegister();
}

}
