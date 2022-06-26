package com.AssertJ;

import org.assertj.core.api.BDDAssertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class AssertJSoftAssertions {
	
//	@Test
	public void assertSoftlyTest() {
		SoftAssertions softly = new SoftAssertions();
		
		softly.assertThat("Hello World")
			.isNotEmpty()
			.hasSize(5)
			.contains("Hello");
		
		System.out.println("Hi");
		
		softly.assertAll();
	}

	@Test
	public void assertBDDStyleTest() {
		
		BDDAssertions.then("Hello World")
						.hasSize(11)
						.containsIgnoringCase("hello");
	}
}
