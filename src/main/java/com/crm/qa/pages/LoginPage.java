package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// all the page factories for each page

	@FindBy(xpath= "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement logInBtn;
	
	@CacheLookup
	@FindBy(name="email")
	WebElement username;
	
	@CacheLookup
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	

	@FindBy(xpath="(//div[@class='ui fluid large blue submit button'])[1]")
	WebElement loginSubmit;
	
	//Initializing page objects
	public LoginPage()
	{
	PageFactory.initElements(driver,  this);
		
	}
	
	//Actions:
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateSubmitButton()
	{

		logInBtn.click();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$Submit button is Displayed "+loginSubmit.isDisplayed());
		return loginSubmit.isDisplayed();
	}
	
	public HomePage login(String un, String pw)
	{
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.visibilityOf(password));
		logInBtn.click();
		username.sendKeys(un);
		password.sendKeys(pw);
		loginSubmit.click();
		
		
		return new HomePage();
	}
	
}
