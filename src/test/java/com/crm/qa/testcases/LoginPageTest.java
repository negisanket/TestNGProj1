package com.crm.qa.testcases;

import java.awt.image.ImagingOpException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Test;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Utilities;


public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest()
	{
		super();
		
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initilization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validatePageTitle();
		System.out.println("Title of page is ========"+title);
		Assert.assertEquals("#1 Free CRM customer relationship management software cloud", title);
		Utilities.takeScreenshot(driver);
		//extenttest = extent.createTest("Title of login Page");
		extenttest.info("Title test");
	}
	
	
	@Test(priority=3)
	public void validateSubmitBtntest() {
		
		boolean a = loginPage.validateSubmitButton();
		Assert.assertTrue(a);
		
		System.out.println("$$$$$$$$$$$$$$$$$$$=======$$$$$$$$$$$$$$$$$$$$$");
		Utilities.takeScreenshot(driver);
		extenttest.info("Submit Button vlaidation");
	
	
	}
	
	@Test(priority=2)
	public void LoginTest()
	{
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Utilities.takeScreenshot(driver);
	
		extenttest.info("Starting login");
		
		
	}
	
	
 @Test
 public void fail()
 {
	 Assert.assertTrue(false);
	 
 }
	
	
	

}
