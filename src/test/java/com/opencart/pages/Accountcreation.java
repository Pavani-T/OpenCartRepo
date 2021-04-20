package com.opencart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.opencart.constants.BaseClass;
import com.opencart.constants.ReadExcel;
import com.opencart.utilities.Waits;

public class Accountcreation extends BaseClass {

	@FindBy(xpath = "//a[@class='dropdown-toggle' and @title='My Account']")
	WebElement myAccount;
	@FindBy(xpath = "//a[text()='Register']")
	WebElement register;
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstName;
	@FindBy(xpath = "//input[@name='lastname']")
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
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn2;
	@FindBy(xpath = "//div[@class='col-sm-10']/div[@class='text-danger']")
	WebElement errorMsg;
	@FindBy(xpath = "//a[text()='Edit Account']")
	WebElement lnkeditAccount;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement msgRead;

	// Elements for logout

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement lnklogOut;

	public Accountcreation() {
		PageFactory.initElements(driver, this);
	}

	public void clicksignin() {

		Waits.waitperiod();
		myAccount.click();
		register.click();

	}

	public void createAccount() {

		Waits.waitperiod();

		firstName.sendKeys(prop.getProperty("FirstName"));
		lastName.sendKeys(prop.getProperty("LastName"));
		email.sendKeys(prop.getProperty("Email"));
		phone.sendKeys(prop.getProperty("Phone"));
		password.sendKeys(prop.getProperty("Password"));
		confirmPwd.sendKeys(prop.getProperty("Password"));
		subscribe.click();
		privacyPolicy.click();
		continueBtn.click();
		continueBtn2.click();
	}

	public void createAccountWithoutPhone() {

		Waits.waitperiod();

		firstName.sendKeys(prop.getProperty("FirstName"));
		lastName.sendKeys(prop.getProperty("LastName"));
		email.sendKeys(prop.getProperty("Email"));
		// phone.sendKeys(prop.getProperty("Phone"));

		password.sendKeys(prop.getProperty("Password"));
		confirmPwd.sendKeys(prop.getProperty("Password"));
		subscribe.click();
		privacyPolicy.click();
		continueBtn.click();
		// continueBtn2.click();
		String error = errorMsg.getText();
		Reporter.log(error);
		System.out.println(error);

	}

	public void editAccount() {
		lnkeditAccount.click();
		lastName.clear();
		lastName.sendKeys(prop.getProperty("LastNameedit"));
		btncontinue.click();
		String actual = ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText", msgRead)
				.toString();
		System.out.println(actual + "----actual msg");
		String expected = prop.getProperty("Successmsg");
		

	}

	public void navigateToHomePage() {
        Waits.waitperiod();
        driver.navigate().to(prop.getProperty("url"));
    }
	

}
