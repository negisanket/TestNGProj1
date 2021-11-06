package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	
	@FindBy(xpath="//span[@class='user-display']")
	public WebElement Elabel1;

	public HomePage() {
		PageFactory.initElements(driver, this);
	
	}
	
	public void validateAcc()
	{
	System.out.println("Account="+Elabel1);
	
	
	}
	
}
