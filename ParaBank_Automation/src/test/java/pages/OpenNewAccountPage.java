package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseTest.BaseClass;

public class OpenNewAccountPage
{
    private By openAccountService=By.xpath("//a[text()='Open New Account']");
	private By accountType=By.xpath("//select[@id='type']");
	private By accountNumber=By.id("fromAccountId");
	private By openAcctBtn=By.cssSelector("input[value='Open New Account']");
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement accountTypeWE,accountNumberWE,openAccountServiceWE;
	public OpenNewAccountPage(WebDriver driver)
	{
		//System.out.println("Here in opennewaccount"+driver);
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
	}
	public void openAccount_Service()
	{
		openAccountServiceWE=driver.findElement(openAccountService);
		wait.until(ExpectedConditions.elementToBeClickable(openAccountServiceWE));
		
	}
	
	public void openNewAccount(String accountDropdown,String accountNo)
	{
		accountTypeWE=driver.findElement(accountType);
		Select select_Account=new Select(accountTypeWE);
		select_Account.selectByValue(accountDropdown);
		accountNumberWE=driver.findElement(accountNumber);
		Select select_AccountNum=new Select(accountNumberWE);
		select_AccountNum.selectByValue(accountNo);
		driver.findElement(openAcctBtn).click();
	}
}
