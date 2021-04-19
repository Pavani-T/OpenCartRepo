package com.opencart.testscripts;



import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.constants.BaseClass;

import com.opencart.pages.HomePage;

import com.opencart.pages.ProductPage;





public class OpenCartTestscripts extends BaseClass{
	
	public OpenCartTestscripts() {
		super();
	}
	HomePage home;
	ProductPage prod;
	
	@Parameters({"browser"})
	@BeforeMethod
		public void beforemethod(String browser) {
		openURL(browser);
		home = new HomePage(); 
		home.loginApp();
	}

	
	@Test(enabled = true, priority=1)
	public void productAvailabitlyInCart() {

		prod = new ProductPage();
		prod.searchProduct.clear();
		prod.searchProduct.sendKeys(prop.getProperty("product"));
		prod.searchBtn.click();
		prod.product(prop.getProperty("product")).click();
		prod.qty.clear();
		prod.qty.sendKeys(prop.getProperty("qty"));
		prod.addToCart.click();
		prod.cartItems.click();
		prod.checkout.click();
		String actValue = prod.alertMsg.getText().trim();
		Assert.assertTrue(actValue.contains(prop.getProperty("alertMsg")));
		prod.removeProduct.click();
		
	}
	
	@Test(enabled = true, priority=2)
	public void removeProductFromCart() {

		prod = new ProductPage();
		Actions act = new Actions(driver);
		act.moveToElement(prod.lapAndNoteProducts).click(prod.showAllLapAndNoteProducts).build().perform();
		prod.product(prop.getProperty("lapTopProduct")).click();
		prod.addToCart.click();
		prod.cartItems.click();
		prod.viewCart.click();
		prod.removeProduct.click();
		prod.continueBtn.click();
		
	}

	
	@Test(enabled = true, priority=3)
	public void applyCouponCode() {

		prod = new ProductPage();
		Actions act = new Actions(driver);
		act.moveToElement(prod.lapAndNoteProducts).click(prod.showAllLapAndNoteProducts).build().perform();
		prod.product(prop.getProperty("lapTopProduct")).click();
		prod.deliveryDate.clear();
		prod.deliveryDate.sendKeys(prop.getProperty("deliveryDate"));
		prod.qty.clear();
		prod.qty.sendKeys(prop.getProperty("qty"));
		prod.addToCart.click();
		prod.cartItems.click();
		prod.viewCart.click();
		prod.useCouponCode.click();
		prod.couponCode.clear();
		prod.couponCode.sendKeys(prop.getProperty("couponCode"));
		prod.applyCouponCode.click();
		prod.removeProduct.click();
		
	}
	
	@AfterMethod()
		public void aftermethod(ITestResult result) {
			String name = result.getName().toString().trim();
			if(result.getStatus() == ITestResult.SUCCESS)
		    {
	           System.out.println(name+"--------passed");
		    }

			else if(result.getStatus() == ITestResult.FAILURE)
		    {
		    	System.out.println(name+"-----failed");
		    
		    	String fileWithPath = System.getProperty("user.dir") + "/screenshots/";
				//String fileWithPath = "E:\\Shweta\\Flipkart\\screenshot\\";
				try {
					takeSnapShot(driver, fileWithPath, name);
				} catch (Exception e) {
					e.printStackTrace();
				}

		    }
		     else if(result.getStatus() == ITestResult.SKIP ){
		        System.out.println(name+"---------Skiped");
		     }
			home = new HomePage(); 
			home.logoutApp();			
			driver.close();
			driver.quit();
			
		     }
	      
}
