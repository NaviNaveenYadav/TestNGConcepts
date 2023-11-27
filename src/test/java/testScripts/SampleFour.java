package testScripts;

import org.testng.annotations.Test;

public class SampleFour {

	@Test(groups="featureOne")
	public void sampleOne() {
		System.out.println("Test 4-1 in SampleFour.java");
	}
	
	@Test(groups="featureTwo")
	public void sampleTwo() {
		System.out.println("Test 4-2 in SampleFour.java");
	}
	
	@Test(groups="featureThree")
	public void sampleThree() {
		System.out.println("Test 4-3 in SampleFour.java");
	}
	
	@Test
	public void sampleFour() {
		System.out.println("Test 4-4 in SampleFour.java");
	}
	
	
}
