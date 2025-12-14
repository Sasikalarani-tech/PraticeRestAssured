package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pages.AccountsOverview;
import pages.OpenNewAccountPage;

public class OpenNewAccountTest extends BaseClass
{
	public OpenNewAccountPage openAccountPage;
	public AccountsOverview accountsOverview;
	private String accountNumber;
	@BeforeClass
	public void openNewAccount_Access()
	{
		//System.out.println("Inside"+driver);
		accountsOverview=new AccountsOverview(driver);
		openAccountPage=new OpenNewAccountPage(driver);

	}
	@Test(priority=1,dependsOnMethods= {"test.CustomerLoginTest.login_Click"})
	public void accountOverview()
	{
		//accountsOverview.accountOverviewService();
		accountNumber=accountsOverview.returnAccountNumber();
		System.out.println(accountNumber);
	}
	@Test(priority=2,dependsOnMethods= {"test.OpenNewAccountTest.accountOverview"})
  public void openNewAccount_Click()
  {
		openAccountPage.openAccount_Service();
		openAccountPage.openNewAccount("SAVINGS",accountNumber);
		
  }
}
