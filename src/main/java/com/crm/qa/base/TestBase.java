package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {   

		
		prop = new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream("/CRM_Automation/src/main/java/com/crm/qa/config/config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void initialization() {
		
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\CRM_Automation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}	
		else if(browsername.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPICIT_WAIT, TimeUnit.SECONDS);
		 
		driver.get(prop.getProperty("url"));
	}

}
