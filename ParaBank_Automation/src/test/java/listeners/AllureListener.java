package listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener
{
	//private Webdriver driver;
	@Override
	public void onTestStart(ITestResult result)
	{
		saveTextLog("TEST STARTED: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		saveTextLog("TEST PASSED: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		saveTextLog("TEST FAILED: " + result.getMethod().getMethodName());
		attachException(result.getThrowable());
		Object currentClass = result.getInstance();
		WebDriver driver = ((baseTest.BaseClass) currentClass).driver;
		takeScreenshot(driver,"ParaBank_Test Results");
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		 saveTextLog("TEST SKIPPED: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		saveTextLog("TEST FAILED WITH SUCCESS %: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{
		 saveTextLog("TEST FAILED WITH TIMEOUT: " + result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context)
	{
		 saveTextLog("SUITE STARTED: " + context.getName());
		
	}

	public void onFinish(ITestContext context)
	{
		 saveTextLog("SUITE FINISHED: " + context.getName());
	}

	public  String saveTextLog(String message)
	{
		
		return message;
	}
	public static String attachException(Throwable throwable )
	{
		 return throwable == null ? "No exception." : throwable.toString();	
	}
	@Attachment(value = "{1}", type = "image/png")
	public void takeScreenshot(WebDriver driver,String fileName)
	{
		 try
		 {
			 File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 File dest = new File("./screenshots/" + fileName + ".png");
		     FileUtils.copyFile(src, dest);
		     System.out.println("Screenshot saved: " + dest.getAbsolutePath());
		 }
		 catch(Exception e)
		 {
			 
		 }
	}

}
