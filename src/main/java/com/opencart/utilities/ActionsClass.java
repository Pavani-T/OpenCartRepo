package com.opencart.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.opencart.constants.BaseClass;


public class ActionsClass extends BaseClass {

	
	public static void actionCode(WebElement ele) {

		Actions action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();

	}

	public static void drag(WebElement ele, WebElement ele1) {
		Actions a = new Actions(driver);
		a.dragAndDrop(ele, ele1).perform();

	}

	public static void doubleClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.doubleClick(ele).perform();
	}

	public static void rightClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.contextClick(ele);
	}
}
