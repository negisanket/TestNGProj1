package com.crm.qa.pages;


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
	
	@FindBy(name="password")
	WebElement password;
	

	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginSubmit;
	
	//Initializing page objects
	public LoginPage()
	{
	PageFactory.initElements(driver,  this);
		
	}
	
	//Actions:
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateSubmitButton()
	{
		logInBtn.click();
	//WebElelmnet loginSubmit2 = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button'][1]"));
		try
		{	WebDriverWait wait = new WebDriverWait(driver, 55);
		wait.until(ExpectedConditions.visibilityOf(loginSubmit));
		}
		catch (Exception e) {
			System.out.println(" Loginbutton Validation Elelment not located"+e.getMessage());
		}
	
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$Submit button is Displayed "+loginSubmit.isDisplayed());
		return loginSubmit.isDisplayed();
	}
	
	public HomePage login(String un, String pw)
	{
		try
		{	WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(password));
		}
		catch (Exception e) {
			System.out.println(" password Elelment not located"+e.getMessage());
		}
		
		
		logInBtn.click();
		username.sendKeys(un);
		password.sendKeys(pw);
		loginSubmit.click();
		
		
		return new HomePage();
	}
	
}
