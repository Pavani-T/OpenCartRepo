package com.opencart.testscripts;

import java.io.FileNotFoundException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.constants.BaseClass;
import com.opencart.listeners.ExtentTestManager;
import com.opencart.pages.Accountcreation;
import com.opencart.pages.AddToCart;
import com.opencart.pages.Addproduct;
import com.opencart.pages.CouponCode;
import com.opencart.pages.FileUpload;
import com.opencart.pages.LoginPage;
import com.opencart.pages.OrderHistory;
import com.opencart.pages.OrderPlacement;
import com.opencart.pages.WishList;
import com.opencart.utilities.ScrollPage;
import com.opencart.utilities.Waits;

public class OpenCartTestscripts extends BaseClass {

	public OpenCartTestscripts() {
		super();
	}

	OpenCartTestscripts open;
	Accountcreation acc;
	LoginPage lp;
	OrderHistory oh;
	Addproduct ap;
	FileUpload fu;
	OrderPlacement op;
	CouponCode cc;
	WishList wl;
	AddToCart at;

	@Parameters({ "browser" })
	@BeforeMethod
	public void beforemethod(String browser) throws FileNotFoundException {
		openURL(browser);
		acc = new Accountcreation();
		lp = new LoginPage();
		at = new AddToCart();
		oh = new OrderHistory();
		ap = new Addproduct();
		fu = new FileUpload();
		op = new OrderPlacement();
		cc = new CouponCode();
		wl = new WishList();
		open = new OpenCartTestscripts();

	}

	// Register
	@Test(enabled = true, priority = 1)
	public void registerAccount() {
		acc.clicksignin();
		acc.createAccount();
	}

	// RegisterWithoutPhone
	@Test(enabled = true, priority = 2)
	public void registerAccountFailure() {
		acc.clicksignin();
		acc.createAccountWithoutPhone();

	}

	// Login
	@Test(enabled = true, priority = 3)
	public void login() {
		lp.clickLogin();
	}

	// VerifyTitle
	@Test(enabled = true, priority = 3)
	public void verifyTitle() {
		lp.clickLogin();
		String actual = driver.getTitle();
		Reporter.log(actual);
		String expected = prop.getProperty("title");
		Reporter.log(expected);
		Assert.assertEquals(actual, expected, "Title matched");
	}

	// AddToCart
	@Test(enabled = true, priority = 4)
	public void addToCart() throws InterruptedException {
		at.click();
		at.scrollpage();
		at.addtocart();
		Thread.sleep(2000);

	}

	// FileUpload
	@Test(enabled = true, priority = 4)
	public void uploadFile() {
		fu.Productselection();
		fu.Addtocartoptions();
	}

	// NavigateToHomePage
	@Test(enabled = true, priority = 8)
	public void navigateHome() {

		acc.clicksignin();
		lp.clickLogin();
		acc.editAccount();
		acc.navigateToHomePage();
	}

	// OrderPlacementWithGuest
	@Test(enabled = true, priority = 5)
	public void orderPlacementWithGuest() {
		op.findProduct();
		op.addToCart();
		op.viewCart();
		op.guestCheckOut();
		Waits.waitperiod();
		op.billingDetails();
		op.guestBillingDetails();
		op.addDeliveryComment();
		op.confirmOrder();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		String fileWithPath = "E:\\JavaPractice\\OpenCartRepo\\screenshot";
		try {
			takeSnapShot(driver, fileWithPath, "GuestCheckout_Confirm-Order");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Billing
	@Test(enabled = true, priority = 7)
	public void billingDetails() {
		op.findProduct();
		op.addToCart();
		op.viewCart();
		op.registerCheckOut();
		Waits.waitperiod();
		op.billingDetails();
		op.registerBillingDetails();
		op.addDeliveryComment();
		op.registerDelivery();
		op.paymentMethod();
		op.confirmOrder();

		Waits.waitperiod();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String fileWithPath = "E:\\JavaPractice\\OpenCartRepo\\screenshot";
		try {
			ExtentTestManager.getTest()
					.addScreenCaptureFromPath(fileWithPath + "RegisterCheckout_Confirm-Order" + ".png");
			takeSnapShot(driver, fileWithPath, "RegisterCheckout_Confirm-Order");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// productAvailabitlyInCart
	@Test(enabled = true, priority = 10)
	public void productAvailabitlyInCart() {

		ap.searchProduct.clear();
		ap.searchProduct.sendKeys(prop.getProperty("product"));
		ap.searchBtn.click();
		ap.product(prop.getProperty("product")).click();
		ap.qty.clear();
		ap.qty.sendKeys(prop.getProperty("qty"));
		ap.addToCart.click();
		Waits.waitperiod();
		ap.cartItems.click();
		ap.checkout.click();
		String actValue = ap.alertMsg.getText().trim();
		Assert.assertTrue(actValue.contains(prop.getProperty("alertMsg")));
		ap.removeProduct.click();

	}

	// removeProductFromCart
	@Test(enabled = true, priority = 11)
	public void removeProductFromCart() {

		Actions act = new Actions(driver);
		act.moveToElement(ap.lapAndNoteProducts).click(ap.showAllLapAndNoteProducts).build().perform();
		ScrollPage.scrollPage();
		ap.product(prop.getProperty("lapTopProduct")).click();
		ap.addToCart.click();
		ap.cartItems.click();
		Waits.waitperiod();
		ap.viewCart.click();
		ap.removeProduct.click();
		ap.continueBtn.click();

	}

	// applyCouponCode
	@Test(enabled = true, priority = 12)
	public void applyCouponCode() {

		Waits.waitperiod();
		Actions act = new Actions(driver);
		act.moveToElement(ap.lapAndNoteProducts).click(ap.showAllLapAndNoteProducts).build().perform();
		Waits.waitperiod();
		ap.product(prop.getProperty("lapTopProduct")).click();
		Waits.waitperiod();
		ap.deliveryDate.clear();
		ap.deliveryDate.sendKeys(prop.getProperty("deliveryDate"));
		ap.qty.clear();
		ap.qty.sendKeys(prop.getProperty("qty"));
		ap.addToCart.click();
		Waits.waitperiod();
		ap.cartItems.click();
		ap.viewCart.click();
		Waits.waitperiod();
		ap.useCouponCode.click();
		ap.couponCode.clear();
		ap.couponCode.sendKeys(prop.getProperty("couponCode"));
		Waits.waitperiod();
		ap.applyCouponCode.click();
		ap.removeProduct.click();

	}

	// emptyCouponCode
	@Test(enabled = true, priority = 13)
	public void emptyCouponCode() throws Exception {
		lp.clickLogin();
		// start
		Actions act = new Actions(driver);
		act.moveToElement(ap.lapAndNoteProducts).click(ap.showAllLapAndNoteProducts).build().perform();
		ap.product(prop.getProperty("lapTopProduct")).click();
		ap.deliveryDate.clear();
		ap.deliveryDate.sendKeys(prop.getProperty("deliveryDate"));
		ap.qty.clear();
		ap.qty.sendKeys(prop.getProperty("qty"));
		ap.addToCart.click();
		// end start to lines are added to add proct in cart

		Waits.waitperiod();
		cc.Empty_Couponcode();
		Waits.waitperiod();
		cc.Estimate_Shipping();
		Waits.waitperiod();
		cc.BillingDetails();

	}

	// whishList
	@Test(enabled = true, priority = 15)
	public void whishListTest() throws InterruptedException {
		Waits.waitperiod();
		wl.wishlist_method();

	}

	// orderHistory
	@Test(enabled = true, priority = 16)
	public void orderHistory() throws Exception {
		//open.emptyCouponCode();
		oh.orderHistoryView();
	}

	@AfterMethod()
	public void aftermethod(ITestResult result) {
		String name = result.getName().toString().trim();
		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println(name + "--------passed");
		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println(name + "-----failed");

			String fileWithPath = "E:\\JavaPractice\\OpenCartRepo\\screenshot";
			try {
				takeSnapShot(driver, fileWithPath, name);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println(name + "---------Skiped");
		}
		driver.close();

	}

}
