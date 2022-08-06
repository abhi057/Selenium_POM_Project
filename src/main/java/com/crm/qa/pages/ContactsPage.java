package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	// Pagefactory
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement ContactsPageLabel;

	@FindBy(xpath = "//div[class='ui checked fitted read-only checkbox'] label")
	WebElement Checkbox1;

	// initiate page elements
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsPageLabel() {
		return ContactsPageLabel.isDisplayed();

	}

	public boolean selectContacts(String name) {
		
//method-1		

//		String beforexpath = "//*[@class='table-wrapper']/table/tbody/tr[";
//		String afterxpath = "]/td[2]//a";
//
//		for (int i = 1; i < 10; i++) {
//			String nameRetrived = driver.findElement(By.xpath(beforexpath + i + afterxpath)).getText();
//			{
//				if (nameRetrived.contains(name)) {
//					driver.findElement(By.xpath("//*[@class='table-wrapper']/table/tbody/tr[" + i + "]/td[1]//input"))
//							.click();
//					break;
//				}
//			}

//		}
		
		
		//Method-2
		WebElement checkbox = driver.findElement(By.xpath("//*[contains(text(), '"+name+"')]/parent::td//preceding-sibling::td//div/input")); 
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", checkbox);
		
		return checkbox.isSelected();
	
		
		
	}

}
