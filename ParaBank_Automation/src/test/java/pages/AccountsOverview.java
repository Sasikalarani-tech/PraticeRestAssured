package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsOverview 
{
private WebDriver driver;	
private WebDriverWait wait;
private WebElement accountNumberWE,accountServiceWE;
private By accountsOverview=By.xpath("//a[text()='Accounts Overview']");
private By accountNumber=By.xpath("//table[@id='accountTable']/tbody/tr/td/a");
public AccountsOverview(WebDriver driver)
{
	this.driver=driver;
	this.wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
}
public void accountOverviewService()
{
	System.out.println(driver.getTitle());
	accountServiceWE=driver.findElement(accountsOverview);
	wait.until(ExpectedConditions.elementToBeClickable(accountServiceWE)).click();
	
	
	
}
public String returnAccountNumber()
{
	accountNumberWE=driver.findElement(accountNumber);
	wait.until(ExpectedConditions.elementToBeClickable(accountNumberWE));
	return accountNumberWE.getText();
}
}
