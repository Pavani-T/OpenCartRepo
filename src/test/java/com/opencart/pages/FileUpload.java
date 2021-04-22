/*
 * Testcases : Upload A File
 * Created By:: Vasantha
 * */

package com.opencart.pages;


import com.opencart.constants.BaseClass;
import com.opencart.utilities.ScrollPage;
import com.opencart.utilities.Waits;

import static org.testng.Assert.assertTrue;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FileUpload extends BaseClass {

	@FindBy(xpath = "//a[@class='dropdown-toggle' and text()='Components']")
	WebElement mouseoveraction;
	@FindBy(xpath = "//a[contains(.,'Monitors (2)')]")
	WebElement Option;
	@FindBy(xpath = "//a[contains(.,'Apple Cinema 30')]")
	WebElement Product;
	@FindBy(xpath = "//input[@name='option[223][]' and @value='10']")
	WebElement Checkbox;
	@FindBy(xpath = "//input[@value='test']")
	WebElement Text;
	@FindBy(xpath = "//select[@name='option[217]']")
	WebElement DropDown;
	@FindBy(xpath = "//textarea[contains(@placeholder,'Textarea')]")
	WebElement TextArea;
	@FindBy(xpath = "//button[@id='button-upload222']")
	WebElement btnUpload;
	@FindBy(xpath = "//input[@name='option[222]']")
	WebElement UploadFile;
	@FindBy(xpath = "//*[@id=\"product\"]/div[6]/div")    
	WebElement fileuploadtext;
	@FindBy(xpath = "(//i[contains(@class,'fa fa-calendar')])[1]")
	WebElement dateWidget;
	@FindBy(xpath = "//input[@name='quantity']")
	WebElement Quantity;
	@FindBy(xpath = "(//button[contains(.,'Add to Cart')])[1]")
	WebElement Addtocart;

	public FileUpload() {
		PageFactory.initElements(driver, this);
	}

	public void Productselection() {
		Actions ac = new Actions(driver);
		ac.moveToElement(mouseoveraction).build().perform();
		Waits.waitForVisibility(Option);
		Option.click();
		Product.click();
	}

	public void Addtocartoptions() {
		ScrollPage.scrollPagedown();
		Waits.waitperiod();
		Checkbox.click();
		Text.clear();
		Text.sendKeys("text");
		Select dropdownoption = new Select(DropDown);
		dropdownoption.selectByValue("3");
		TextArea.clear();
		TextArea.sendKeys("Hello");
		UploadFile();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date today = Calendar.getInstance().getTime();
		String date = dateFormat.format(today);

		List<WebElement> columns = dateWidget.findElements(By.tagName("i"));

		// comparing the text of cell with today's date and clicking it.
		for (WebElement cell : columns) {
			if (cell.getText().equals(today)) {
				cell.click();
				break;
			}
		}

		Quantity.clear();
		Quantity.sendKeys("2");
		Addtocart.click();
		ScrollPage.scrollPageup();
		String errormessage = fileuploadtext.getText();
		if(errormessage.equals("File required!")==true) {
			String fileWithPath = "E:\\Shweta\\OpenCartRepo\\screenshot\\";
			try {
				takeSnapShot(driver, fileWithPath, "File upload failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			

	}

	public void UploadFile() {
		Waits.waitperiod();
//		btnUpload.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("document.getElementsByName('option[222]').value='E:\\Wells Fargo\\New Text Document.txt'");  
//		btnUpload.sendKeys("E:\\Wells Fargo\\New Text Document.txt");
//		UploadFile.sendKeys("E:\\Wells Fargo\\New Text Document.txt");
		
		}

	

}