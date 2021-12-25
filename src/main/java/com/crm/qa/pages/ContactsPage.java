package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;



public class ContactsPage extends TestBase {

	@FindBy(linkText="Contacts")
	public WebElement contactLink;
	
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	public WebElement contactLabel;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void goToContact()
	{
		contactLink.click();
System.out.println("Label is"+contactLabel.getText());
	}
	
}
