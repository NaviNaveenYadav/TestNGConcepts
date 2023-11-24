package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.*;


public class GooglePageTest {
	
	WebDriver driver;
	
//	@BeforeMethod
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
	}
  
	
  @Test
  public void javaSearchTest() {
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  driver.get("https://www.google.com/");
	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Java Tutorial");
	  srcBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	 
  }  

	  @Test
	  public void seleniumSearchTest() {
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  
		  driver.get("https://www.google.com/");
		  WebElement srcBox = driver.findElement(By.id("APjFqb"));
		  srcBox.sendKeys("Selenium Tutorial");
		  srcBox.submit();
		  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
		  
	  }
	  
//	 @AfterMethod
	 @AfterTest
	 public void tearDown() {
		 driver.close();
	 }  

	 
//Test Suite --> Tests --> Classes --> Methods	 
	 
}

