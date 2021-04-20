/*
 * Testcases : WishList
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencart.constants.BaseClass;


public class WishList extends BaseClass{
	
	 @FindBy(xpath = "(//a[contains(@class,'dropdown-toggle')])[4]")
	 WebElement components;
	 @FindBy(xpath = "//a[contains(@href,'28')]")
	 WebElement monitors;
	 @FindBy(xpath = "//select[@id='input-sort']")
	 WebElement sortby_dropdown;
	 @FindBy(xpath = "(//i[contains(@class,'fa fa-heart')])[2]")
	 WebElement wishlist_button;
	 @FindBy(xpath = "//span[contains(.,'Wish List (1)')]")
	 WebElement wishlist_icon;
	 @FindBy(xpath = "(//i[contains(@class,'fa fa-shopping-cart')])[3]")
	 WebElement addtocart;
	 Date d = new Date();
	 
	 String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
	 
	 
	 public WishList(){
	 PageFactory.initElements(driver, this);
	 }
	 
	public void wishlist_method() throws InterruptedException{
	 Actions action = new Actions(driver);
	 action.moveToElement(components).click().build().perform();
	 monitors.click();
	 
	 Select select = new Select(sortby_dropdown);
	 select.selectByIndex(4);
	 Thread.sleep(3000);
	 
	 wishlist_button.click();
	 Thread.sleep(2000);
	 wishlist_icon.click();
	 addtocart.click();
	 Thread.sleep(2000);
	 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 try {
	 FileUtils.copyFile(screenshot, new File("E:\\JavaPractice\\OpenCartRepo\\screenshot" + FileName));
	 } catch (IOException e) {
	 }
	 
	 
	 }

}
