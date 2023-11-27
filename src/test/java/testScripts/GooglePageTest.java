package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.*;


public class GooglePageTest {
	
	WebDriver driver;
	
//	@BeforeMethod
	@Parameters("browser")
	@BeforeTest
	public void setUp(String strBrowser) {
		if(strBrowser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(strBrowser.equals("Edge")) {
			driver = new EdgeDriver();
		}
		
		else if(strBrowser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
	}
  
	
  @Test(alwaysRun = true, dependsOnMethods = "seleniumSearchTest")
  public void javaSearchTest() {
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  SoftAssert softAssert = new SoftAssert();
	  driver.get("https://www.google.com/");
	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Java Tutorial");
	  srcBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
//	  softAssert.assertEquals(driver.getTitle(), "Java Tutorial - Google");
//	  softAssert.assertAll();
	 
  }  
  
	  @Test(priority = 2)
	  public void seleniumSearchTest() {
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  
		  driver.get("https://www.google.com/");
		  WebElement srcBox = driver.findElement(By.id("APjFqb"));
		  srcBox.sendKeys("Selenium Tutorial");
		  srcBox.submit();
		  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
		  
	  }
	  

	  @Test(enabled = false)
	  public void cyPressSearchTest() {
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  
		  driver.get("https://www.google.com/");
		  WebElement srcBox = driver.findElement(By.id("APjFqb"));
		  srcBox.sendKeys("CyPress Tutorial");
		  srcBox.submit();
		  Assert.assertEquals(driver.getTitle(), "CyPress Tutorial - Google Search");
		  
	  }
	  
	  
	  @Test(enabled = false)
	  public void appiumSearchTest() {
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  
		  driver.get("https://www.google.com/");
		  WebElement srcBox = driver.findElement(By.id("APjFqb"));
		  srcBox.sendKeys("Appium Tutorial");
		  srcBox.submit();
		  Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");
		  
	  }	 
	  
	  
//	 @AfterMethod
	 @AfterTest
	 public void tearDown() {
		 driver.close();
	 }  

	 
//Hierarchy ==>  Test Suite --> Tests --> Classes --> Methods	 
	 
}

