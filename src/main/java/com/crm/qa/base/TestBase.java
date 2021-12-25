package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.crm.qa.util.Utilities;
import java.lang.reflect.Method;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest extenttest;
	public ITestResult result;
	
	@BeforeSuite
	public void setUpSuite()
	{
		spark = new ExtentSparkReporter(new File(prop.getProperty("Usr.dir")+Utilities.getCurrentDateTime()+"Ex-index.html")); //$NON-NLS-1$ //$NON-NLS-2$
		extent = new ExtentReports();
		//spark.config().setTheme(Theme.DARK);	
		//spark.config().setDocumentTitle("CRM TITLE");
		extent.attachReporter(spark);
	}
	
	
	public TestBase()  //constructor
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(Messages.getString("TestBase.2")); //$NON-NLS-1$
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			
		System.out.println("File path is incorrect or file is missing"); //$NON-NLS-1$
		}
		catch (IOException e) {
			System.out.println(" IO Exception for ip"); //$NON-NLS-1$
		}
	}
	
	//@Parameters("browserName")
	public void initilization()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	String browserName =	prop.getProperty("browser"); //$NON-NLS-1$
		
		if (browserName.equals("chrome")) { //$NON-NLS-1$
			System.out.println("Browser is==="+browserName); //$NON-NLS-1$
			 driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")) { //$NON-NLS-1$
			
		}
		else {
			System.out.println("Browser not define dproperly"); //$NON-NLS-1$
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url")); //$NON-NLS-1$
		
	}
	
	@BeforeMethod
	public void extentSetup(Method method) {
		
		extenttest = extent.createTest(method.getName());
		Reporter.log("Method Started: "+method.getName(),true); //$NON-NLS-1$
	}
	
	
	@AfterMethod
	public void methodTearDown(ITestResult result) throws IOException
	{
		Reporter.log("getStatus value"+result.getStatus(),true); //$NON-NLS-1$
		Reporter.log("ITestResult.FAILURE"+ITestResult.FAILURE,true); //$NON-NLS-1$
		Reporter.log("ITestResult.SUCCESS"+ITestResult.SUCCESS,true); //$NON-NLS-1$
		if(result.getStatus() == ITestResult.FAILURE)
		{
			
		//	Utilities.takeScreenshot(driver);
			extenttest.fail("TC failed", MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshot(driver)).build()); //$NON-NLS-1$ //$NON-NLS-2$
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
			extenttest.pass("Success", MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshot(driver)).build()); //$NON-NLS-1$
		
		
		extent.flush();	
		driver.quit(); //do not use driver.close()
	}

	
}









//add IRetry Analyzer

