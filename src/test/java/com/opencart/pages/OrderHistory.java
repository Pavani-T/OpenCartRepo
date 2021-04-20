package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.constants.BaseClass;

public class OrderHistory extends BaseClass{
	
	
	@FindBy(xpath = "(//a[text()='Order History'])[3]")
	WebElement orderHistory;
	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement view;

	public OrderHistory() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void orderHistoryView() throws Exception {
		
		orderHistory.click();
		view.click();
		BaseClass.takeSnapShot(driver, "E:\\JavaPractice\\OpenCartRepo\\screenshot", "ViewOrder");
	}
	
	
}
