package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerLoginPage
{
	private WebDriver driver;
	private WebDriverWait wait;
	private WebElement userNameWE,passwordWE,logInBtWE;
	private By userName=By.cssSelector("input[name='username']");
	private By password=By.cssSelector("input[name='password']");
	private By logInBtn=By.cssSelector("input[value='Log In']");
public CustomerLoginPage(WebDriver driver)
{
	this.driver=driver; 
	this.wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
}
public void logIn(String userNam,String passwd)
{
	
	userNameWE=driver.findElement(userName);
	wait.until(ExpectedConditions.elementToBeClickable(userNameWE)).sendKeys(userNam);
	passwordWE=driver.findElement(password);
	wait.until(ExpectedConditions.elementToBeClickable(passwordWE)).sendKeys(passwd);
	logInBtWE=driver.findElement(logInBtn);
	wait.until(ExpectedConditions.elementToBeClickable(logInBtWE)).click();
}
}
