package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseClass 
{
	public static WebDriver driver;
	@BeforeSuite(alwaysRun=true)
	public void setUp_driver()
	{
		//System.out.println("Inside Base");
		//System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromeDriver/chromedriver_140/chromedriver-win64/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(ConfigReader.get("url"));
		driver.manage().window().maximize();
	}
	@AfterSuite
	public void close()
	{
		driver.quit();
	}
 
}
