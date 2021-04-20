/*
 * Testcases : OrderPlacement using Guest checkout, 
 * 				OrderPlacement using register checkout
 * Created By:: Joshi
 * */


package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencart.constants.BaseClass;
import com.opencart.constants.ReadExcel;
import com.opencart.utilities.ScrollPage;
import com.opencart.utilities.Waits;

public class OrderPlacement extends BaseClass {

	@FindBy(xpath = "//a[@class='dropdown-toggle' and text()='Laptops & Notebooks']")
	WebElement laptops;
	@FindBy(xpath = "//a[@class='see-all' and text()='Show All Laptops & Notebooks']")
	WebElement showLaptops;

	// @FindBy(xpath="//img[@title='HP LP3065']") WebElement hpproduct;
	@FindBy(xpath = "//a[text() ='HP LP3065']")
	WebElement hpProduct;
	@FindBy(id = "input-option225")
	WebElement date;

	@FindBy(id = "button-cart")
	WebElement addToCart;
	@FindBy(id = "cart")
	WebElement viewCart;

	@FindBy(xpath = "//a[@href='https://demo.opencart.com/index.php?route=checkout/checkout']")
	WebElement btnCheckOut;
	@FindBy(xpath = "//a[@class='panel-title' and text()='Step 1: Checkout Options']")
	WebElement checkOutOptions;

	@FindBy(name = "firstname")
	WebElement firstName;

	@FindBy(name = "lastname")
	WebElement lastName;
	@FindBy(id = "input-payment-telephone")
	WebElement phone;
	@FindBy(id = "input-payment-email")
	WebElement email;
	@FindBy(id = "input-payment-password")
	WebElement paymentPsw;
	@FindBy(id = "input-payment-confirm")
	WebElement paymentConfirmPsw;
	@FindBy(name = "address_1")
	WebElement address;
	@FindBy(name = "city")
	WebElement city;
	@FindBy(name = "postcode")
	WebElement postcode;
	@FindBy(id = "input-payment-zone")
	WebElement region;
	@FindBy(id = "input-payment-country")
	WebElement country;
	@FindBy(id = "button-guest")
	WebElement btncontinue;
	@FindBy(xpath = "//input[@value='guest']")
	WebElement rdoguestCheckout;
	@FindBy(xpath = "//input[@value='register']")
	WebElement rdoregisterCheckout;
	@FindBy(id = "button-account")
	WebElement btncheckoutContinue;
	@FindBy(name = "comment")
	WebElement deliveryComment;
	@FindBy(id = "button-shipping-method")
	WebElement btndeliveryContinue;
	@FindBy(id = "button-payment-method")
	WebElement btndeliveryContinueafter;
	@FindBy(id = "button-shipping-address")
	WebElement btnregisterDeliverContinue;
	@FindBy(name = "agree")
	WebElement agreeTerms;
	@FindBy(id = "button-confirm")
	WebElement btnconfirmOrder;
	@FindBy(xpath = "//input[@name='agree' and @value='1']")
	WebElement registerBillingCheckbox;
	@FindBy(xpath = "//input[@id='button-register' and @value='Continue']")
	WebElement btnregisterBillingContinue;
	@FindBy(id = "button-payment-method")
	WebElement btnpaymentContinue;

	public OrderPlacement() {
		PageFactory.initElements(driver, this);
	}

	public void findProduct() {

		Actions pointer = new Actions(driver);
		pointer.clickAndHold(laptops).build().perform();
		showLaptops.click();
		Waits.waitperiod();
		ScrollPage.scrollPage();
		// Waits.waitperiod();
		hpProduct.click();
		Waits.waitperiod();
		// ScrollPage.scrollPagedown();
		date.clear();
		date.sendKeys("2021-04-23");
	}

	public void addToCart() {
		addToCart.click();
	}

	public void viewCart() {
		viewCart.click();
		Waits.waitForVisibility(btnCheckOut);
	}

	public void guestCheckOut() {

		btnCheckOut.click();
		Waits.waitForVisibility(rdoguestCheckout);
		rdoguestCheckout.click();
		btncheckoutContinue.click();

	}

	public void registerCheckOut() {

		btnCheckOut.click();
		Waits.waitForVisibility(rdoregisterCheckout);
		rdoregisterCheckout.click();
		btncheckoutContinue.click();

	}

	public void billingDetails() {

		firstName.sendKeys(prop.getProperty("FirstName"));
		Waits.waitperiod();
		lastName.sendKeys(prop.getProperty("LastName"));
		email.sendKeys(prop.getProperty("Emailnew"));
		phone.sendKeys(prop.getProperty("Phone"));
		address.sendKeys(prop.getProperty("Address"));
		city.sendKeys(prop.getProperty("City"));
		postcode.sendKeys(prop.getProperty("PostalCode"));
		Select country1 = new Select(country);
		country1.selectByVisibleText(prop.getProperty("Country"));
		Waits.waitperiod();
		// ScrollPage.scrollPagedown();
		Select state = new Select(region);
		state.selectByVisibleText(prop.getProperty("Region/State"));

	}

	public void guestBillingDetails() {
		btncontinue.click();
	}

	public void registerBillingDetails() {
		paymentPsw.sendKeys(prop.getProperty("Password"));
		paymentConfirmPsw.sendKeys(prop.getProperty("Password"));

		// ScrollPage.scrollPagedown();
		registerBillingCheckbox.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		// executor.executeScript("arguments[0].click();", btnregisterBillingContinue);
		btnregisterBillingContinue.click();

	}

	public void addDeliveryComment() {
		deliveryComment.sendKeys(prop.getProperty("DeliveryComment"));
		btndeliveryContinue.click();
		agreeTerms.click();
		btndeliveryContinueafter.click();
	}

	public void registerDelivery() {

		btnregisterDeliverContinue.click();

	}

	public void paymentMethod() {

		deliveryComment.sendKeys(prop.getProperty("DeliveryComment"));
		registerBillingCheckbox.click();
		btnpaymentContinue.click();
	}

	public void confirmOrder() {
		btnconfirmOrder.click();
	}

}
