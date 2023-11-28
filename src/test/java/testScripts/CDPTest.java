package testScripts;

import org.apache.commons.codec.binary.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.log.Log;
import org.openqa.selenium.devtools.v116.log.model.LogEntry;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.devtools.v116.network.model.Headers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CDPTest {

	//CDP --> Chrome Developer Protocol
	
	ChromiumDriver driver;
	DevTools devTools;
	
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		devTools = driver.getDevTools();
		devTools.createSession();
	}
	
	@Test
	public void deviceModeTest() {
		Map deviceMetrics = new HashMap() {{
			put("width", 600);
			put("height", 800);
			put("deviceScaleFactor", 50);
			put("mobile", true);
		}};
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		driver.get("https://www.selenium.dev/");
	}
	
	
	@Test
	public void geoLocationTest() {
		
		Map deviceMetrics = new HashMap() {{
			
			put("latitude", 33.748997);
			put("longitude", -84.387985);
			put("accuracy",100);
			
		}};
	driver.executeCdpCommand("Emulation.setGeolocationOverride", deviceMetrics);
	driver.get("https://oldnavy.gap.com/stores");
}
	
	
	@Test
	public void captureConsoleLogTest() {
		
		devTools.send(Log.enable());
		devTools.addListener(Log.entryAdded(),
				new Consumer<LogEntry>() {
			public void accept(LogEntry logEntry) {
				System.out.println("log : " + logEntry.getText());
				System.out.println("Level : " + logEntry.getLevel());
			}
		}
				);
		
		driver.get("https://the-internet.herokuapp.com/");
	}
	
	
	@Test
	public void basicAuthTest() {
		
//		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		Map<String,Object> headers = new HashMap();
		String strUser = "admin";
		String strPwd = "admin";
		
		String basicAuth = "Basic " + new String(new Base64().encode(
				String.format("%s:%s", strUser,strPwd).getBytes()));
		
		System.out.println("Auth.... + " + basicAuth);
		
		headers.put("Authorization", basicAuth);
		devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		String strMsg = driver.findElement(By.cssSelector("div.example p")).getText();
		Assert.assertEquals(strMsg, "Congratulations! You must have the proper credentials.");
	}
	
	
}
