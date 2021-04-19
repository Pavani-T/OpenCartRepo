package com.opencart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.constants.BaseClass;
import com.opencart.constants.ReadExcel;
import com.opencart.utilities.Waits;



public class Accountcreation extends BaseClass {

	
	
	@FindBy(xpath = "//a[@class='dropdown-toggle' and @title='My Account']")
	WebElement myAccount;
	@FindBy(xpath = "//a[text()='Register']")
	WebElement register;
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='input-lastName']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement phone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmPwd;
	@FindBy(xpath = "//input[@value=1 and @name='newsletter']")
	WebElement subscribe;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacyPolicy;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;
	

	public Accountcreation() {
		PageFactory.initElements(driver, this);
	}

	public void clicksignin() {

		Waits.waitperiod();
		myAccount.click();
		register.click();
		
	}

	public void createaccount() {
		
		Waits.waitperiod();
		
		firstName.sendKeys(ReadExcel.getcellvalue("FirstName"));
		lastName.sendKeys(ReadExcel.getcellvalue("LastName"));
		email.sendKeys(ReadExcel.getcellvalue("Email"));
		phone.sendKeys(ReadExcel.getcellvalue("Phone"));
		password.sendKeys(ReadExcel.getcellvalue("Password"));
		confirmPwd.sendKeys(ReadExcel.getcellvalue("Password"));
		subscribe.click();
		privacyPolicy.click();
		continueBtn.click();
	}

	/*public void login() {

		Createaccount.click();
		Loginemail.sendKeys(ReadExcel.getcellvalue("Username"));
		Loginpsw.sendKeys(ReadExcel.getcellvalue("Password"));

	}

	public void signout() {
		Actions pointer = new Actions(driver);
		pointer.clickAndHold(account).build().perform();
		pointer.click(signout).build().perform();
		Waits.waitperiod();
	}*/

	
	
}
