package com.opencart.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.constants.BaseClass;

public class Waits extends BaseClass{

	public static long IMPLICIT_WAIT = 80;
	
	public static void waitperiod() {
		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public static void waitForVisibility(WebElement element) {
           new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }
}

