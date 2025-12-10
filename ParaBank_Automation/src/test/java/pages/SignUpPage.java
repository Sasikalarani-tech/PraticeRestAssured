package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage 
{
	WebDriver driver;
	WebDriverWait wait;
	private By firstName=By.id("customer.firstName");
	private By lastName=By.cssSelector("#customer\\.lastName");
	private By address=By.cssSelector("#customer\\.address\\.street");
	private By city=By.cssSelector("#customer\\.address\\.city");
	private By state=By.cssSelector("#customer\\.address\\.state");
	private By zipCode=By.cssSelector("#customer\\.address\\.zipCode");
	private By phoneNumber=By.cssSelector("#customer\\.phoneNumber");
	private By SSN=By.cssSelector("#customer\\.ssn");
	private By userName=By.cssSelector("#customer\\.username");
	private By password=By.cssSelector("#customer\\.password");
	private By confirmPassword=By.cssSelector("#repeatedPassword");
	private By regsiterButton=By.cssSelector("input[value='Register']");
	
public SignUpPage(WebDriver driver)
{
	this.driver=driver;
	this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
}
public void enterFirstName()
{
	wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys("Angel");
	
}
public void enterLastName()
{
	wait.until(ExpectedConditions.elementToBeClickable(lastName)).sendKeys("Mathew");
}
public void enterAddress()
{
	wait.until(ExpectedConditions.elementToBeClickable(address)).sendKeys("55 second street");
}
public void enterCity()
{
	wait.until(ExpectedConditions.elementToBeClickable(city)).sendKeys("Coimbatore");
}
public void enterState()
{
	wait.until(ExpectedConditions.elementToBeClickable(state)).sendKeys("Johor");
}
public void enterzipCode()
{
	wait.until(ExpectedConditions.elementToBeClickable(zipCode)).sendKeys("83456");
}
public void enterphoneNumber()
{
	wait.until(ExpectedConditions.elementToBeClickable(phoneNumber)).sendKeys("634567890");
}
public void enterSSN()
{
	wait.until(ExpectedConditions.elementToBeClickable(SSN)).sendKeys("1234567");
}
public void enteruserName()
{
	wait.until(ExpectedConditions.elementToBeClickable(userName)).sendKeys("angel@gmail.com");
}
public void enterpassword()
{
	wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("abc@123");
}
public void enterconfirmPassword()
{
	wait.until(ExpectedConditions.elementToBeClickable(confirmPassword)).sendKeys("abc@123");
}
public void clickRegister()
{
	wait.until(ExpectedConditions.elementToBeClickable(regsiterButton)).click();;
}



}
