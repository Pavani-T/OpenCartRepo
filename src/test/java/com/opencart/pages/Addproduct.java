package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.opencart.constants.BaseClass;
import com.opencart.constants.ReadExcel;
import com.opencart.utilities.Waits;

public class Addproduct extends BaseClass {

	@FindBy(id = "nav-tab-01")
	WebElement lighting;
	@FindBy(xpath = "//a[@title='Ceiling Lights']")
	WebElement ceilinglight;
	@FindBy(xpath = "//a[@title='Ceiling Lights Chandeliers']")
	WebElement Chandeliers;
	@FindBy(xpath = "//a[@title='Chandeliers Large Chandeliers']")
	WebElement LargeChandeliers;
	@FindBy(xpath = "//span[contains(text(),'Contemporary')]")
	WebElement style;
	@FindBy(xpath = "//input[@class='fa-check-wc']")
	WebElement ship;
	@FindBy(xpath = "//a[@title='Suspenders 36\" 4 Tier LED Tri-Bar']")
	WebElement product;
	@FindBy(id = "add-to-cart")
	WebElement addtocart;
	@FindBy(xpath = "//a[contains(text(),'CHECKOUT')]")
	WebElement checkout;
	@FindBy(id = "mcBookMark")
	WebElement viewCart;
	@FindBy(xpath = "//button[@class='imagebuttonCO continuecheckout continueCOtop']")
	WebElement checkOutBtn;
	@FindBy(xpath = "//input[@name='dwfrm_cart_couponCode']")
	WebElement promocode;
	@FindBy(xpath = "//input[@name='dwfrm_cart_addCoupon']")
	WebElement applycode;
	@FindBy(xpath = "//span[@class='taxCalcErr show']")
	WebElement zipmsg;
	@FindBy(xpath = "(//input[contains(@placeholder,'Enter ZIP')])[2]")
	WebElement zipcode;
	@FindBy(xpath = "(//input[contains(@value,'Go')])[2]")
	WebElement go;

	public Addproduct() {
		PageFactory.initElements(driver, this);
	}

	public void findproduct() {

		Actions pointer = new Actions(driver);
		pointer.clickAndHold(lighting).build().perform();
		ceilinglight.click();
		// waitperiod();
		Chandeliers.click();
		// waitperiod();
		LargeChandeliers.click();
	}

	public void applyfilter() {

		ship.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		style.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		product.click();
		Waits.waitperiod();
	}

	public void addtocart() {
		addtocart.click();

		checkout.click();

	}

	public void removeproduct() {

	}

	public void viewcart() {
		viewCart.click();
		Waits.waitForVisibility(checkOutBtn);
	}

	public void couponcode() {
		promocode.sendKeys(ReadExcel.getcellvalue("pcode"));
		applycode.click();

	}

	public void Zipmethod() {
		zipcode.sendKeys(ReadExcel.getcellvalue("zipcode"));
		// zipcode.sendKeys("M1R 0E9");
		go.click();
		String actualmsg = zipmsg.getText();
		String expectedmsg = "Please provide a valid US ZIP Code or Canadian Postal Code";
		if (actualmsg.equalsIgnoreCase(expectedmsg)) {
			Reporter.log("You entered correct zipcode");
		} else {
			Reporter.log("You entered incorrect zipcode");
		}
	}

}
