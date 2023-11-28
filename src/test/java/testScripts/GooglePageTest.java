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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtils.Utility;

import org.testng.*;


public class GooglePageTest {
	
	WebDriver driver;
	
	
	ExtentReports reports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		reports = new ExtentReports();
		spark = new ExtentSparkReporter("target/SparkReport.html")
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[] {
						ViewName.DASHBOARD,
						ViewName.TEST,
						ViewName.AUTHOR,
						ViewName.DEVICE,
						ViewName.LOG
						
				}).apply();
		reports.attachReporter(spark);
	}
	
	
	@BeforeMethod
	@Parameters("browser")
//	@BeforeTest
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
	  
	  extentTest = reports.createTest("Java Search Test");
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
		  
		  extentTest = reports.createTest("Selenium Search Test");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  
		  driver.get("https://www.google.com/");
		  WebElement srcBox = driver.findElement(By.id("APjFqb"));
		  srcBox.sendKeys("Selenium Tutorial");
		  srcBox.submit();
		  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search Page");
		  
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
	  
	  
	 @AfterMethod
//	 @AfterTest
	 public void tearDown(ITestResult result) {
		 extentTest.assignAuthor("Naveen");
		 extentTest.assignDevice(System.getProperty("os.name"));
		 extentTest.assignDevice(System.getProperty("os.version"));
		 extentTest.assignCategory("Regression");
		 
		 if(ITestResult.FAILURE == result.getStatus()) {
			 extentTest.log(Status.FAIL, result.getThrowable().getMessage());
			 
			 String strPath = Utility.getScreenshotPath(driver);
			 extentTest.fail(
					 MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
		 }
		 
		 driver.close();
	 }  

	 @AfterTest
	 public void finishExtent() {
		 reports.flush();
	 }
	 
//Hierarchy ==>  Test Suite --> Tests --> Classes --> Methods	 
	 
}

