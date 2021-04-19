package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.constants.BaseClass;
import com.opencart.constants.ReadExcel;
import com.opencart.utilities.Waits;

public class HomePage extends BaseClass{

	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccountLink;	
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//li/a[text()='Login']")
	WebElement loginLink;
	
	@FindBy(xpath = "//li/a[text()='Logout']")
	WebElement logoutLink;
	
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath ="//p[text()='Welcome to OpenCart!']")
	WebElement welComeMsg;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	public void loginApp() {
		myAccountLink.click();
		loginLink.click();
		email.clear();
		email.sendKeys(prop.getProperty("email"));
		password.clear();
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();		

	}
	
	public void logoutApp() {
		myAccountLink.click();
		logoutLink.click();

	}
}
