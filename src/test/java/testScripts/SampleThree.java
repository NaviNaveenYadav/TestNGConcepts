package testScripts;

import org.testng.annotations.Test;

public class SampleThree {

	@Test(groups="featureOne")
	public void one() {
		System.out.println("Test 3-1 in SampleThree.java");
	}
	
	@Test(groups="featureTwo")
	public void two() {
		System.out.println("Test 3-2 in SampleThree.java");
	}
	
	@Test
	public void three() {
		System.out.println("Test 3-3 in SampleThree.java");
	}
	
	@Test
	public void four() {
		System.out.println("Test 3-4 in SampleThree.java");
	}
	
}
