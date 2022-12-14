package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;  
	ContactsPage contactsPage;

	public HomePageTest()        
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); 
		contactsPage = new ContactsPage();
	} 
	
	@Test(priority=1)
	public void verifyHomePageTitle()
	{
		String actualTitle =  homePage.getHomePageTitle();
		String expectedTitle = "Cogmento CRM";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=2)
	public void verifyUsername()
	{
		Assert.assertTrue(homePage.verifyUsername());
	}
	
	
	@Test(priority=3)
	public void verifyContactLinkTest()
	{
		contactsPage = homePage.clickOnContactsBtn();
	}
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}
	
	
	
}
