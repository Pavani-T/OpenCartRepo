/*
 * Testcases : Login, VerifyTitle, AddToCart
 * Created By:: Rohith
 * */


package com.opencart.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.constants.BaseClass;
import com.opencart.utilities.Waits;

public class AddToCart extends BaseClass {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	@FindBy(xpath = "(//a[contains(.,'Desktops')])")
	WebElement Desktop;
	@FindBy(xpath = "//a[contains(.,'Mac (1)')]")
	WebElement Mac;
	@FindBy(xpath = "//img[contains(@src,'1-228x228.jpg')]")
	WebElement iMac;
	@FindBy(xpath = "//button[contains(@id,'button-cart')]")
	WebElement AddToCart1;

	public AddToCart() throws FileNotFoundException {
		PageFactory.initElements(driver, this);

	}

	public void click() {

		Actions pointer = new Actions(driver);
		pointer.moveToElement(Desktop).build().perform();
		// pointer.moveToElement(Mac).click().build().perform();
		Mac.click();
	}

	public void addtocart() {
		iMac.click();
		AddToCart1.click();

	}

	public void scrollpage() {

		js.executeScript("window.scrollBy(0,1000)");
		Waits.waitperiod();
		js.executeScript("window.scrollBy(0,-1000)");
	}

}
