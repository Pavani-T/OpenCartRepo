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
import com.opencart.utilities.Waits;

public class OpenCartTestscripts extends BaseClass {

	public OpenCartTestscripts() {
		super();
	}

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
	@BeforeTest
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
		/*
		 * try { ReadExcel.setExcelFile("testdata"); } catch (IOException e) {
		 * e.printStackTrace(); } ReadExcel.getRowCountInSheet();
		 */
	}
	/*
	 * @Test(enabled=true,priority=3) public void TC_Lumens_003() { String
	 * actual=driver.getTitle(); Reporter.log(actual); String expected=
	 * prop.getProperty("title"); Reporter.log(expected);
	 * Assert.assertEquals(actual, expected, "Title matched"); }
	 */

	@Test(enabled = true, priority = 1)
	public void registerAccount() {
		acc.clicksignin();
		acc.createAccount();
	}

	@Test(enabled = true, priority = 2)
	public void registerAccountFailure() {
		acc.clicksignin();
		acc.createAccountWithoutPhone();

	}

	@Test(enabled = true, priority = 3)
	public void login() {
		lp.clickLogin();
	}
	@Test(enabled=true,priority=3)
    public void verifyTitle()
    {
        String actual = driver.getTitle();
        Reporter.log(actual);
        String expected= prop.getProperty("title");
        Reporter.log(expected);
        Assert.assertEquals(actual, expected, "Title matched");
    }
    
    @Test(enabled=true,priority=4)
    public void addToCart() throws InterruptedException
    {
    	at.click();
    	at.scrollpage();
    	at.addtocart();
        Thread.sleep(2000);
        /*String fileWithPath = "E:\\JavaPractice\\OpenCartRepo\\screenshot";
          try {
        
            takeSnapShot(driver, fileWithPath, "TC_OpenCart_004");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

	@Test(enabled = false, priority = 4)
	public void uploadFile() {
		fu.productSelection();
		fu.addToCartOptions();
	}

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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String fileWithPath = "E:\\JavaPractice\\OpenCartRepo\\screenshot";
		try {
			takeSnapShot(driver, fileWithPath, "GuestCheckout_Confirm-Order");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(enabled = true, priority = 7)
	public void TC_OpenCart_007() {
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String fileWithPath = "E:\\JavaPractice\\OpenCartRepo\\screenshot";
		try {
			ExtentTestManager.getTest()
					.addScreenCaptureFromPath(fileWithPath + "RegisterCheckout_Confirm-Order" + ".png");
			takeSnapShot(driver, fileWithPath, "RegisterCheckout_Confirm-Order");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(enabled = true, priority = 10)
	public void productAvailabitlyInCart() {

		ap.searchProduct.clear();
		ap.searchProduct.sendKeys(prop.getProperty("product"));
		ap.searchBtn.click();
		ap.product(prop.getProperty("product")).click();
		ap.qty.clear();
		ap.qty.sendKeys(prop.getProperty("qty"));
		ap.addToCart.click();
		ap.cartItems.click();
		ap.checkout.click();
		String actValue = ap.alertMsg.getText().trim();
		Assert.assertTrue(actValue.contains(prop.getProperty("alertMsg")));
		ap.removeProduct.click();

	}

	@Test(enabled = true, priority = 11)
	public void removeProductFromCart() {

		// ActionsClass.actionCode(ap.lapAndNoteProducts);
		
		 Actions act = new Actions(driver);
		  act.moveToElement(ap.lapAndNoteProducts).click(ap.
		  showAllLapAndNoteProducts).build().perform();
		  ap.product(prop.getProperty("lapTopProduct")).click();
		  ap.addToCart.click(); ap.cartItems.click(); ap.viewCart.click();
		  ap.removeProduct.click(); ap.continueBtn.click();
		 

	}

	@Test(enabled = true, priority = 12)
	public void applyCouponCode() {

		// ActionsClass.actionCode(ap.lapAndNoteProducts);
		
		  Actions act = new Actions(driver);
		  act.moveToElement(ap.lapAndNoteProducts).click(ap.
		  showAllLapAndNoteProducts).build().perform();
		  ap.product(prop.getProperty("lapTopProduct")).click();
		  ap.deliveryDate.clear();
		  ap.deliveryDate.sendKeys(prop.getProperty("deliveryDate"));
		  ap.qty.clear(); ap.qty.sendKeys(prop.getProperty("qty"));
		  ap.addToCart.click(); ap.cartItems.click(); ap.viewCart.click();
		  ap.useCouponCode.click(); ap.couponCode.clear();
		  ap.couponCode.sendKeys(prop.getProperty("couponCode"));
		  ap.applyCouponCode.click(); ap.removeProduct.click();
		 

	}
	
	
	@Test(enabled = true, priority = 13)
    public void emptyCouponCode() throws Exception{
		
		lp.clickLogin();
        cc.Empty_Couponcode();
        cc.Estimate_Shipping();
        cc.BillingDetails();
        
    }
    
    /*@Test(enabled = true, priority = 14)
    public void estimateShipping() throws InterruptedException{
        
    	
        //scroll.scrol_page();
        
    }*/
    @Test(enabled = true, priority = 15)
    public void whishListTest() throws InterruptedException{
    	
        wl.wishlist_method();
        
    }

	@Test(enabled = false, priority = 16)
	public void orderHistory() throws Exception {

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
		/*
		 * driver.close(); driver.quit();
		 */

	}

}
