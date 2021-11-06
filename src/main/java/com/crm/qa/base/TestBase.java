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
		spark = new ExtentSparkReporter(new File(prop.getProperty("Usr.dir")+Utilities.getCurrentDateTime()+"Ex-index.html"));
		extent = new ExtentReports();
		//spark.config().setTheme(Theme.DARK);	
		//spark.config().setDocumentTitle("CRM TITLE");
		extent.attachReporter(spark);
	}
	
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Sanket Negi\\eclipse-workspace\\TestNGproj1\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			
		System.out.println("File path is incorrect or file is missing");
		}
		catch (IOException e) {
			System.out.println(" IO Exception for ip");
		}
	}
	
	
	public void initilization()
	{
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		
	String browserName =	prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.out.println("Browser is==="+browserName);
			 driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
			
		}
		else {
			System.out.println("Browser not define dproperly");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	@BeforeMethod
	public void extentSetup(Method method) {
		
		extenttest = extent.createTest(method.getName());
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
		//	Utilities.takeScreenshot(driver);
			extenttest.fail("TC failed", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Sanket Negi\\Pictures\\Fail.jpg").build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
			extenttest.pass("Success", MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshot(driver)).build());
		
		
		extent.flush();	
		driver.quit();
	}

	
}






// Add testn.xml
//add listner from testng. xml
//log4j
//IRetry Analyzer

