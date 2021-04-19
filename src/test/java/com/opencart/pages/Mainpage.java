package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.constants.BaseClass;
import com.opencart.utilities.Waits;


public class Mainpage extends BaseClass {

	@FindBy(id="searchinput") WebElement searchbox;
	@FindBy(id="simplesearchbtn") WebElement searchbtn;
	@FindBy(id="nav-icon-chat") WebElement livechat;
	@FindBy(id="txt_4616424") WebElement namelivechat;
	@FindBy(id="txt_4616425") WebElement emaillivechat;
	@FindBy(xpath="//button[contains(text(),'Submit')]") WebElement submit;
	@FindBy(id="mcBookMark") WebElement cart;
	@FindBy(xpath="//span[@class='qty-increment-decrement qty-decrement']")  WebElement decqty;
	@FindBy(xpath="//span[@class='qty-increment-decrement qty-increment']")  WebElement incqty;
	@FindBy(name="dwfrm_cart_shipments_i0_items_i0_quantity")  WebElement qty;
	public Mainpage() {
		PageFactory.initElements(driver, this);
	}
	
	public void searchproduct() {
		
		searchbox.sendKeys("Swell Medium Pendant");
		searchbtn.click();
		Waits.waitperiod();
	}
	
	public void gotolivechat() {
		
		livechat.click();
		namelivechat.sendKeys(prop.getProperty("FirstName"));
		emaillivechat.sendKeys(prop.getProperty("Email"));
		submit.click();
	}
	
	public void incorrectchat() {
		
		livechat.click();
		namelivechat.sendKeys(prop.getProperty("FirstName"));
		emaillivechat.sendKeys(prop.getProperty("incorrectemail"));
		submit.click();
	}
	public void navigation() {
	
	driver.navigate().back();    
	}
	public void gotocart() {
		cart.click();
	}
	public void incrementqty() {
		int  preqty = Integer.parseInt(qty.getText());
		incqty.click();
		int nextqty =Integer.parseInt(qty.getText());
		if(nextqty > preqty) {
			System.out.println("Quantity Increased");
		}
		
	}
	
	
}
