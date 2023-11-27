package parallelScripts;

import org.testng.annotations.Test;

public class SampleThree {

	@Test
	public void test1() {
		long id = Thread.currentThread().getId();
		System.out.println("3-1 in Sample Three class" + id);
	}
	
	@Test
	public void test2() {
		long id = Thread.currentThread().getId();
		System.out.println("3-2 in Sample Three class" + id);
	}
	
	@Test
	public void test3() {
		long id = Thread.currentThread().getId();
		System.out.println("3-3 in Sample Three class" + id);
	
	}

}