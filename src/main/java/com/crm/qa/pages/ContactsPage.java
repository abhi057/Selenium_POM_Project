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

	@FindBy(xpath = "//*[@href='/contacts/new']")
	WebElement createNewContactBtn;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstname;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastname;

	@FindBy(xpath = "//div[@name='company']//input[@type='text']")
	WebElement company;
	
	@FindBy(xpath = "//*[@class='save icon']//parent::button")
	WebElement saveBtn;

	// initiate page elements
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsPageLabel() {
		return ContactsPageLabel.isDisplayed();

	}

	public void addContact(String fn, String ln, String comp) {
		createNewContactBtn.click();
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		company.sendKeys(comp);
		saveBtn.click();
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

		// Method-2
		WebElement checkbox = driver.findElement(
				By.xpath("//*[contains(text(), '" + name + "')]/parent::td//preceding-sibling::td//div/input"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", checkbox);

		return checkbox.isSelected();

	}

}
