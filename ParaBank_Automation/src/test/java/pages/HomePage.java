package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage
{
	private By register_Click=By.xpath("//a[contains(text(),'Register')]");
	WebDriver driver;
	WebElement registerClick_WE;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		System.out.println(driver);
	}
	
	public void register()
	{
		//registerClick_WE=;
		System.out.println("HomePage regsiter Started");
		driver.findElement(register_Click).click();
		driver.getCurrentUrl();
	}

}
