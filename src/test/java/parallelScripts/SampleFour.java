package parallelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleFour {

	@Test
	public void test1() {
		
		long id = Thread.currentThread().getId();
		System.out.println("4-1 in Sample Four class" + id);
	}
	
	@Test
	public void test2() {
		
		long id = Thread.currentThread().getId();
		System.out.println("4-2 in Sample Four class" + id);
	}
	
	@Test
	public void test3() {
		
		long id = Thread.currentThread().getId();
		System.out.println("4-3 in Sample Four class" + id);
	
	}
	
	@Test
	public void test4() {
		
		long id = Thread.currentThread().getId();
		System.out.println("4-4 in Sample Four class" + id);
	
	}

}