package parallelScripts;

import org.testng.annotations.Test;

public class SampleTwo {

	@Test
	public void test1() {
		long id = Thread.currentThread().getId();
		System.out.println("2-1 in Sample two class" + id);
	}
	
	@Test
	public void test2() {
		long id = Thread.currentThread().getId();
		System.out.println("2-2 in Sample two class" + id);
	}
	
	@Test
	public void test3() {
		long id = Thread.currentThread().getId();
		System.out.println("2-3 in Sample two class" + id);
	
	}

}