/*
 * Testcases :Product Availability,Remove Product, Apply couponcode 
 * Created By:: Ramesh
 * */

package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.opencart.constants.BaseClass;
import com.opencart.constants.ReadExcel;
import com.opencart.utilities.Waits;

public class Addproduct extends BaseClass {

	@FindBy(xpath = "//div[@id='search']/input")
	public WebElement searchProduct;
	
	@FindBy(xpath = "//div[@id='search']/span")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li/a[text()='Laptops & Notebooks']")
	public WebElement lapAndNoteProducts;
	
	@FindBy(xpath = "//div[@class='dropdown-menu']/a[text()='Show All Laptops & Notebooks']")
	public WebElement showAllLapAndNoteProducts;
	
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right']//button[@title='Remove']")
	public WebElement removeProductFromCartItems;
	


	
	public WebElement product(String pName) {
		
		return driver.findElement(By.xpath("//div[@class='product-thumb']//div[@class='caption']/h4/a[text()='"+pName+"']"));
		
	}
	
	@FindBy(xpath="//div[@id='product']//input[@name='quantity']")
	public  WebElement qty;
	
	@FindBy(xpath="//div[@id='product']//button[@id='button-cart']")
	public WebElement addToCart;
	
	@FindBy(xpath="//div[@id='cart']")
	public WebElement cartItems;

	@FindBy(xpath="//ul[@class='dropdown-menu pull-right']//a[contains(@href,'checkout/checkout')]")
	public WebElement checkout;
	
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right']//a[contains(@href,'checkout/cart')]")
	public WebElement viewCart;

	@FindBy(xpath="//div[contains(@class,'alert')]")
	public WebElement alertMsg;
	
	@FindBy(xpath="//span[@class='input-group-btn']/button[@data-original-title='Remove']")
	public WebElement removeProduct;
	
	@FindBy(xpath="//a[text()='Continue']")
	public WebElement continueBtn;
	
	
	@FindBy(xpath="//div[@class='input-group date']/input")
	public WebElement deliveryDate;
	
	@FindBy(xpath="//a[text()='Use Coupon Code']")
	public WebElement useCouponCode;
	
	@FindBy(xpath="//input[@id='input-coupon']")
	public WebElement couponCode;	

	
	@FindBy(xpath="//input[@id='button-coupon']")
	public WebElement applyCouponCode;


	public Addproduct() {
		PageFactory.initElements(driver, this);
	}

	
}

