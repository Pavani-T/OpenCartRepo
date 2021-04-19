package com.opencart.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.constants.BaseClass;
import com.opencart.constants.ReadExcel;
import com.opencart.pages.Accountcreation;
import com.opencart.pages.Addproduct;
import com.opencart.pages.Mainpage;
import com.opencart.utilities.Waits;




public class OpenCartTestscripts extends BaseClass{
	
	public OpenCartTestscripts() {
		super();
	}
	Accountcreation acc;
	//Addproduct prd;
	//Mainpage main;
	
	@Parameters({"browser"})
	@BeforeMethod
		public void beforemethod(String browser) {
		openURL(browser);
		acc = new Accountcreation(); 
		//prd= new Addproduct();
		//main= new Mainpage();
		try {
			ReadExcel.setExcelFile("testdata");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ReadExcel.getRowCountInSheet();
	}
	/*@Test(enabled=true,priority=3)
	public void TC_Lumens_003() {
		String actual=driver.getTitle();
		Reporter.log(actual);
		String expected= prop.getProperty("title");
		Reporter.log(expected);
		Assert.assertEquals(actual, expected, "Title matched");
	}*/
	
	@Test(enabled=true,priority=1)
	public void TC_Lumens_001() {
		acc.clicksignin();
		acc.createaccount();
	}
	/*@Test(enabled=true,priority=2)
	public void TC_Lumens_002() {
		acc.clicksignin();
		acc.login();
	}	
	@Test(enabled=true,priority=4)
	public void TC_Lumens_004() {
		acc.clicksignin();
		acc.login();
		prd.findproduct();
	}
 
	@Test(enabled=true,priority=5)
	public void TC_Lumens_005() {
		acc.clicksignin();
		prd.findproduct();
		prd.applyfilter();
		
	}
	@Test(enabled= true,priority=6)
	public void TC_Lumens_006() {
		acc.clicksignin();
		acc.login();
		prd.findproduct();
		Waits.waitperiod();
		prd.applyfilter();
		prd.addtocart();
		
	}
	@Test(enabled =true,priority=7)
    public void TC_Lumens_007() {
        acc.clicksignin();
        acc.login();
        prd.findproduct();
        Waits.waitperiod();
        prd.applyfilter();
        prd.addtocart();
        prd.viewcart();
    }
	
	@Test(enabled= true,priority=8)
	public void TC_Lumens_008() {
		acc.clicksignin();
		acc.login();
		main.searchproduct();
		
	}
	
	@Test(enabled=true,priority=9)
	public void TC_Lumens_009() {
		main.gotolivechat();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
    @Test(enabled=true,priority=10)
	public void TC_Lumens_010() {
			main.incorrectchat();
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
	}

    @Test(enabled=true,priority=11)
    public void TC_Lumens_011() {
        acc.clicksignin();
        acc.login();
        prd.findproduct();
        Waits.waitperiod();
        prd.applyfilter();
        prd.addtocart();
        prd.removeproduct();

    }
    @Test(enabled=true,priority=12)
    public void TC_Lumens_012() {
        acc.clicksignin();
        acc.login();
        prd.findproduct();
        Waits.waitperiod();
        prd.applyfilter();
        Waits.waitperiod();
        prd.addtocart();
        Waits.waitperiod();
        prd.couponcode();
        
    }

        
    @Test(enabled=true,priority=13)
    public void TC_Lumens_013() {
        acc.clicksignin();
        acc.login();
        acc.scrollpage();
    }

    @Test(enabled=true,priority=14)
    public void TC_Lumens_014() {
        acc.clicksignin();
        acc.login();
        main.searchproduct();
        main.navigation();
    }


    @Test(enabled=true,priority=15)
    public void TC_Lumens_015() {
        acc.clicksignin();
        acc.login();
        prd.findproduct();
        Waits.waitperiod();
        prd.applyfilter();
        Waits.waitperiod();
        prd.addtocart();
        prd.Zipmethod();

    }
    @Test(enabled=true,priority=16)
    public void TC_Lumens_016() {
        
        acc.clicksignin();
        acc.login();
        main.gotocart();
        main.incrementqty();

    }




    @Test(enabled=true,priority=17)
    public void TC_Lumens_017() {
        
        acc.clicksignin();
        acc.login();
        acc.signout();        
    }
    */
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
		    
				String fileWithPath = "E:\\Shweta\\Flipkart\\screenshot\\";
				try {
					takeSnapShot(driver, fileWithPath, name);
				} catch (Exception e) {
					e.printStackTrace();
				}

		    }
		     else if(result.getStatus() == ITestResult.SKIP ){
		        System.out.println(name+"---------Skiped");
		     }
			driver.close();
			driver.quit();
			
		     }
	      
}
