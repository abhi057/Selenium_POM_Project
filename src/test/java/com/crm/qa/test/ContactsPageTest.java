package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;  
	ContactsPage contactsPage;
	String sheetName = "Contacts";
	
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
	
	
//    @Test(priority=1)
//    public void verifyContactsPagelabel() {
//    	Assert.assertTrue(contactsPage.verifyContactsPageLabel());
//    }
    
//    @Test(priority=2)
//    public void selectContactsCheckbox() {
//    	Assert.assertTrue(contactsPage.selectContacts("Abhi a")); 
//    	Assert.assertTrue(contactsPage.selectContacts("Vid M"));    
//          
//    }
    
    @DataProvider
    public Object[][] getCRMTestData() {
    	Object data[][] = TestUtil.getTestData(sheetName);
    	return data;
    }
    
    
    @Test(priority=3, dataProvider = "getCRMTestData")
    public void enterContacts(String fn, String ln, String comp) {
    	
    	//contactsPage.addContact("Rahul", "Dravid", "BCCI");
    	contactsPage.addContact(fn, ln, comp);
    }
    
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}
	
	
	

}
