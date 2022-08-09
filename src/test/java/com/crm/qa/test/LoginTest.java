package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest() {
		super();
	}
		
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void firstPageTitleTest() {	
		//String expectedTitle = "Free CRM software for customer relationship management, sales, marketing campaigns and support.";
		String expectedTitle = "#1 Free CRM customer relationship management software cloud";
		String actualTitle = loginPage.getFirstpageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test(priority=2)
	public void loginTest()
	{
	  loginPage.login(prop.getProperty("username"), prop.getProperty("password")); 
//		String expectedTitle = "Cogmento CRM";
//		String actualTitle = loginPage.getHomePageTitle();
//		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterMethod
	public void tearDown() 
	{
	//	driver.wait(3000);
		driver.quit();
	}
}

