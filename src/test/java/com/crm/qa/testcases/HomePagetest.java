package com.crm.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class HomePagetest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePagetest() {
	super();	
	}
	

	@BeforeMethod
	public void setUp()
	{
		initilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
	@Test
	public void validateAccount()
	{
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String AccountName = prop.getProperty("ExpLabel");
		System.out.println("Account name is Displayed="+homePage.Elabel1.getText()+ "      "+AccountName);
		Assert.assertEquals(AccountName, homePage.Elabel1.getText());
		
	}
	
	
	
}
