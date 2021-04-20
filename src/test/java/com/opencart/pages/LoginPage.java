package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.constants.BaseClass;
import com.opencart.utilities.Waits;

public class LoginPage extends BaseClass{

	@FindBy(xpath = "//a[@class='dropdown-toggle' and @title='My Account']")
	WebElement myAccount;
	@FindBy(xpath = "(//a[contains(.,'Login')])[1]")
	WebElement loginBtn;
	@FindBy(xpath = "//input[contains(@id,'input-email')]")
	WebElement email;
	@FindBy(xpath = "//input[contains(@id,'input-password')]") 
	WebElement pwd;
	@FindBy(xpath = "//input[@class='btn btn-primary']") 
	WebElement buttonLogin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public void clickLogin() {

		Waits.waitperiod();
		myAccount.click();
		loginBtn.click();
		email.sendKeys(prop.getProperty("Email"));
		pwd.sendKeys(prop.getProperty("Password"));
		buttonLogin.click();
		
	}
	
	
	
}
