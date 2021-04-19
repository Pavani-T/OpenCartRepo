package com.opencart.utilities;

import org.openqa.selenium.JavascriptExecutor;

import com.opencart.constants.BaseClass;

public class ScrollPage extends BaseClass{
	
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public static void  scrollPage() {

		js.executeScript("window.scrollBy(0,1000)");
		Waits.waitperiod();
		js.executeScript("window.scrollBy(0,-1000)");
	}


}
