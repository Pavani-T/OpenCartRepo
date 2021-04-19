package com.opencart.testscripts;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.constants.BaseClass;
import com.opencart.constants.ReadExcel;
import com.opencart.pages.Accountcreation;

public class AccountCreationTest extends BaseClass{

	Accountcreation acc;
	public AccountCreationTest() {
		super();
	}
	@Parameters({"browser"})
	@BeforeMethod
		public void beforemethod(String browser) {
		openURL(browser);
		acc = new Accountcreation(); 
		/*try {
			ReadExcel.setExcelFile("testdata");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ReadExcel.getRowCountInSheet();*/
	}
	@Test(enabled=true,priority=1)
	public void TC_Lumens_001() {
		acc.clicksignin();
		acc.createaccount();
	}
	
}
