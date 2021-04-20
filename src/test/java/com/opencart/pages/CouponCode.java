/*
 * Testcases : CouponCode
 * Created By:: Sandeep
 * */

package com.opencart.pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencart.constants.BaseClass;
 

public class CouponCode extends BaseClass {
	
	@FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md'][contains(.,'Shopping Cart')]")
	 WebElement shoppingcart;
	
	 @FindBy(xpath = "//a[contains(.,'Use Coupon Code')]")
	 WebElement couponcode;
	 @FindBy(xpath = "//input[@id='button-coupon']")
	 WebElement apply_couponcode;
	 
	 @FindBy(xpath = "//a[contains(.,'Estimate Shipping & Taxes')]")
	 WebElement shipping;
	 @FindBy(xpath = "//select[@id='input-country']")
	 WebElement country;
	 @FindBy(xpath = "//select[@id='input-zone']")
	 WebElement state;
	 @FindBy(xpath = "//input[@id='input-postcode']")
	 WebElement postcode;
	 @FindBy(xpath = "//button[@id='button-quote']")
	 WebElement get_quotes;
	 @FindBy(xpath = "//input[contains(@name,'shipping_method')]")
	 WebElement shipping_method;
	 @FindBy(xpath = "//input[@id='button-shipping']")
	 WebElement shipping_button;
	 @FindBy(xpath = "//div[@class = 'pull-right']/a")
	 WebElement checkout;
	 
	 
	 @FindBy(xpath = "//input[@id='input-payment-firstname']")
	 WebElement B_Fistname;
	 @FindBy(xpath = "//input[@id='input-payment-lastname']")
	 WebElement B_lastname;
	 @FindBy(xpath = "//input[@id='input-payment-company']")
	 WebElement company;
	 @FindBy(xpath = "//input[@id='input-payment-address-1']")
	 WebElement Address1;
	 @FindBy(xpath = "//input[@id='input-payment-address-2']")
	 WebElement Address2;
	 @FindBy(xpath = "//input[@id='input-payment-city']")
	 WebElement city;
	 @FindBy(xpath = "//input[@id='input-payment-postcode']")
	 WebElement B_postcode;
	 @FindBy(xpath = "//select[@id='input-payment-country']")
	 WebElement payment_country;
	 @FindBy(xpath = "//select[@id='input-payment-zone']")
	 WebElement B_state;
	 @FindBy(xpath = "//input[@id='button-payment-address']")
	 WebElement cont;
	 
	 @FindBy(xpath = "//input[@id='button-payment-address']")
	 WebElement continue_address;
	 @FindBy(xpath = "//input[@id='button-shipping-address']")
	 WebElement shipping_address;
	 @FindBy(xpath = "//textarea[contains(@name,'comment')]")
	 WebElement add_comments;
	 @FindBy(xpath = "//input[contains(@id,'button-shipping-method')]")
	 WebElement comment_cont;
	 
	 @FindBy(xpath = "//input[@name= 'agree']")
	 WebElement terms_cond;
	 @FindBy(xpath = "//input[@id='button-payment-method']")
	 WebElement payment_method;
	 
	 @FindBy(xpath = "//input[@id='button-confirm']")
	 WebElement confirm_btn;
	 @FindBy(xpath = "//a[contains(@class,'btn btn-primary')]")
	 WebElement backto_home;
	 
	 
	 Date d = new Date();
	 
	 String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
	 public CouponCode() {
	 PageFactory.initElements(driver, this);
	 }
	 
	 public void Empty_Couponcode() throws InterruptedException {
	 shoppingcart.click();
	 couponcode.click();
	 apply_couponcode.click();
	 // Here we have to take screenshot
	 Thread.sleep(2000);
	 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 try {
	 FileUtils.copyFile(screenshot, new File("E:\\JavaPractice\\OpenCartRepo\\screenshot" + FileName));
	 } catch (IOException e) {
	 }
	 }
	 
	 public void Estimate_Shipping() throws InterruptedException {
	 shipping.click();
	 
	 Select select = new Select(country);
	 select.selectByVisibleText("India");
	 
	 Select select1 = new Select(state);
	 select1.selectByVisibleText("Telangana");
	 // postcode.sendKeys(ReadExcel.getcellvalue("postalcode"));
	 postcode.sendKeys(prop.getProperty("postalcode1"));
	 
	 get_quotes.click();
	 shipping_method.click();
	 shipping_button.click();
	 Thread.sleep(2000);
	 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 try {
	 FileUtils.copyFile(screenshot, new File("E:\\JavaPractice\\OpenCartRepo\\screenshot" + FileName));
	 } catch (IOException e) {
	 }
	 
	 }
	 
	 public void BillingDetails() throws InterruptedException {
	 
	 checkout.click();
	 Thread.sleep(2000);
	 /*
	 B_Fistname.sendKeys(prop.getProperty("Firstname"));
	 B_lastname.sendKeys(prop.getProperty("Lastname"));
	 company.sendKeys(prop.getProperty("Comp"));
	 Address1.sendKeys(prop.getProperty("add1"));
	 Address2.sendKeys(prop.getProperty("add2"));
	 city.sendKeys(prop.getProperty("City1"));
	 
	 B_postcode.sendKeys(prop.getProperty("postalcode"));
	 Thread.sleep(2000);
	 
	 Select sel = new Select(payment_country);
	 sel.selectByVisibleText("India");
	 
	 Select sel1 = new Select(B_state);
	 sel1.selectByVisibleText("Telangana");
	 cont.click();*/
	 
	 continue_address.click();
	 Thread.sleep(3000);
	 
	 shipping_address.click();
	 Thread.sleep(3000);
	 add_comments.sendKeys(prop.getProperty("comment"));
	 comment_cont.click();
	 
	 Thread.sleep(3000);
	 terms_cond.click();
	 payment_method.click();
	 Thread.sleep(3000);
	 confirm_btn.click();
	 backto_home.click();
	 
	 }
	 
	}


