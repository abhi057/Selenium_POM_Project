package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage {
	
	//page Factory
	
	@FindBy(xpath="//span[text()=\"Log In\"]")
	WebElement login;

}
