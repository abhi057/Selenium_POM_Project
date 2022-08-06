package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;  
	ContactsPage contactsPage;
	
	public ContactsPageTest(){
		super(); 
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); 
		contactsPage = new ContactsPage();
		contactsPage = homePage.clickOnContactsBtn();
		
	}  
	
	
    @Test(priority=1)
    public void verifyContactsPagelabel() {
    	Assert.assertTrue(contactsPage.verifyContactsPageLabel());
    }
    
    @Test(priority=2)
    public void selectContactsCheckbox() {
    	Assert.assertTrue(contactsPage.selectContacts("Vid M"));    
          
    }
    
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}
	
	
	

}
