/*
 * *Base Class
 */

package com.opencart.constants;


import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
		
		public static WebDriver driver;
		public static Properties prop;
		public  static WebDriverWait wait;
		
	
		public BaseClass() {
//	Load Properties File 
				prop = new Properties();
				FileInputStream file;
				try {
					file = new FileInputStream("E:\\JavaPractice\\OpenCartRepo\\src\\main\\java\\com\\opencart\\"
							+ "config\\config.properties");
					prop.load(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		public static WebDriver gotoChromeDriver() {
			System.out.println("Script running by google chrome browser");
			System.setProperty("webdriver.chrome.driver", "E:\\JavaPractice\\OpenCartRepo\\Drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			return driver;
		}

		public static WebDriver gotoFirefoxDriver() {
			System.out.println("Script running by Firefox browser");
			System.setProperty("webdriver.gecko.driver","E:\\JavaPractice\\OpenCartRepo\\Drivers\\geckodriver.exe");
			WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			return driver;
		}
		
		
//	Open the URL 
				
		public static void openURL(String browsertype){
			
			
			if(browsertype.equals("chrome")) {
				driver = gotoChromeDriver();
			}
			if(browsertype.equals("firefox")) {
				driver = gotoFirefoxDriver();
			}
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
  
		}
		
		
		public static void takeSnapShot(WebDriver webdriver,String fileWithPath,String name) throws Exception{

			
		       File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        
		        //Copy the file to a location and use try catch block to handle exception
		        try {
		            FileUtils.copyFile(screenshot, new File(fileWithPath+ name+ ".png"));
		        } catch (IOException e) {
		            System.out.println(e.getMessage());
		        }                       
		    }
		
	
}
