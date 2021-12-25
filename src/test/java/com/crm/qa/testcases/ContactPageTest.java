package com.crm.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class ContactPageTest extends TestBase
{
	

	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public ContactPageTest()
	{
		super();
	}
	

	@BeforeMethod
	public void setUp()
	{
		initilization();
loginPage = new LoginPage();
contactsPage = new ContactsPage();
	}
	
	
	
	//@AfterMethod
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
