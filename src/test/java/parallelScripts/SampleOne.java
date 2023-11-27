package parallelScripts;

import org.testng.annotations.Test;

public class SampleOne {

	@Test
	public void test1() {
		long id = Thread.currentThread().getId();
		System.out.println("1-1 in Sample one class" + id);
	}
	
	@Test
	public void test2() {
		long id = Thread.currentThread().getId();
		System.out.println("1-2 in Sample one class" + id);
	}
	
	@Test
	public void test3() {
		long id = Thread.currentThread().getId();
		System.out.println("1-3 in Sample one class" + id);
	
	}
	
	@Test(invocationCount = 8 , threadPoolSize = 3 , timeOut = 5000)
	public void test4() {
		long id = Thread.currentThread().getId();
		System.out.println("1-4 in Sample one class" + id);
	
	}

}