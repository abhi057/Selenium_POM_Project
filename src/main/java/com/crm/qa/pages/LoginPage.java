package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
   //Webelements   	

   @FindBy(xpath="//span[text()=\"Log In\"]")
	WebElement loginlink;
	
   @FindBy(xpath="//input[@name=\"email\" and @type=\"text\"]")
   WebElement username;
   
   @FindBy(xpath="//input[@name=\"password\" and @type=\"password\"]")
   WebElement password;	
   
   @FindBy(xpath="//div[text()='Login']")
   WebElement LoginBtn;
	
	
  //Initializing the page objects 
  public LoginPage()
  {
	  PageFactory.initElements(driver, this);
  }
  
  //Actions
  public String getFirstpageTitle()
  {
	  return driver.getTitle();
  }
  
  public String getHomePageTitle()
  {
	  return driver.getTitle();
  
  }	  
  
  public HomePage login(String un, String pwd)
  {
	 loginlink.click(); 
     username.sendKeys(un);
     password.sendKeys(pwd); 
     LoginBtn.click();
     
     return new HomePage();
  }

}