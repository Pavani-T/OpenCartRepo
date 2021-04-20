/*
 * Testcases : Upload A File
 * Created By:: Vasantha
 * */


package com.opencart.pages;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.opencart.constants.BaseClass;
import com.opencart.utilities.Waits;




	public class FileUpload extends BaseClass{

		 
		FileUpload ff;
	    @FindBy(xpath = "(//a[contains(@class,'dropdown-toggle')])[4]")
	        WebElement mouseoverAction;
	    @FindBy(xpath = "//a[contains(.,'Monitors (2)')]")
	         WebElement option;
	    @FindBy(xpath = "//a[contains(.,'Apple Cinema 30')]")
	            WebElement product;
	    @FindBy(xpath = "//label[contains(.,'Checkbox 3(+$30.00)')]")
	          WebElement checkbox;
	    @FindBy(xpath = "//input[@value='test']")
	          WebElement text;
	    @FindBy(xpath = "//select[@name='option[217]']")
	         WebElement dropDown;
	    @FindBy(xpath = "//textarea[contains(@placeholder,'Textarea')]")
	         WebElement textArea; 
	    @FindBy(xpath = "//button[@id='button-upload222']")
	         WebElement uploadFile;
	    @FindBy(xpath = "(//i[contains(@class,'fa fa-calendar')])[1]")
	         WebElement dateWidget;
	    @FindBy(xpath = "//input[@name='quantity']")
	         WebElement quantity;
	    @FindBy(xpath = "(//button[contains(.,'Add to Cart')])[1]")
	         WebElement addToCart;
	    
	    public  void productSelection() {

	 
	    	//Waits.waitForVisibility(MouseoverAction);
	    	//ActionsClass.actionCode(MouseoverAction);
	    	Actions ac = new Actions(driver);
	        ac.moveToElement(mouseoverAction).click().build().perform();
	        Waits.waitForVisibility(option);
	        option.click();
	        product.click();
	    }
	    
	    public  void  addToCartOptions(){
	        checkbox.click();
	        text.clear();
	        text.sendKeys("text");
	        Select dropdownoption = new Select(dropDown); 
	        dropdownoption.selectByIndex(0);  
	        textArea.clear();
	        textArea.sendKeys("Hello");
	        uploadFile();
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
	        Date today = Calendar.getInstance().getTime();
	        String date = dateFormat.format(today);
	        
	        List<WebElement> columns=dateWidget.findElements(By.tagName("i"));  

	 

	        //comparing the text of cell with today's date and clicking it.
	        for (WebElement cell : columns)
	        {
	           if (cell.getText().equals(today))
	           {
	              cell.click();
	              break;
	           }
	            }
	    
	        quantity.clear();
	        quantity.sendKeys("2");
	    
	    }
	    public  void  uploadFile(){
	    
	        uploadFile.click();
	        Waits.waitperiod();
	        uploadFile.sendKeys("C:\\Users\\user\\Desktop\\WF\\interviewquestions.txt");
	        String File = "interviewquestions.txt";
	        if(uploadFile.equals(File)) {
	        assertTrue(true, "File is Uploaded");
	        }else {
	        assertTrue(false, "File not Uploaded");
	        }
	        }
	   
	   /* @Test
	    public void fileUpload() {
	    	
	    	ff = new FileUpload();
	    	ff.productSelection();
	    	ff.addToCartOptions();
	    
	    }*/
	    }