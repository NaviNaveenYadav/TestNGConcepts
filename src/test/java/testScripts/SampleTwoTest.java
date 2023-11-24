package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTwoTest {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	 @Test
	 public void playwrightSearchTest() {
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  
		  driver.get("https://www.google.com/");
		  WebElement srcBox = driver.findElement(By.id("APjFqb"));
		  srcBox.sendKeys("Playwright Tutorial");
		  srcBox.submit();
		  Assert.assertEquals(driver.getTitle(), "Playwright Tutorial - Google Search");
		 
	  }  
	
	 @AfterTest
	 public void tearDown() {
		 driver.close();
	 }
	
}
