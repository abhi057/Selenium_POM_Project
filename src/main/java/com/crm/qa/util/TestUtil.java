package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPICIT_WAIT = 10;


//switch to a frame with frame name
public void switchToFrame(String fname){

	driver.switchTo().frame(fname);

}




}