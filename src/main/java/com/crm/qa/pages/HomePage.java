package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Abhishek Ang')]")
	WebElement userNameTxt;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement ContactsBtn;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement DealsBtn;
	
	//Initializing page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions or Methods
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsBtn(){
		
		ContactsBtn.click();
		return new ContactsPage();

   }
	
	public DealsPage clickOnDealsBtn(){
		
		ContactsBtn.click();
		return new DealsPage();

   }
	
	public boolean verifyUsername() {
		return userNameTxt.isDisplayed();
	}
	

}