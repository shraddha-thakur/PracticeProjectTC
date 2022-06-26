package com.dataprovider.latest;

import java.util.Arrays;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDependencyInjection {
	
	@BeforeMethod
	// Can inject only one of <ITestContext, XmlTest, Method, Object[], ITestResult> into a @BeforeMethod annotated test1
	 public void setUp(Object[] data) {
		System.out.println(Arrays.toString(data)); // [shraddha, abc124]
		
		
	}
	@Test(dataProvider = "getData")
	public void test1(String username, String password) {
		System.out.println(username + " is test method");
	}

	@DataProvider
			public Object[][] getData() {
			
		return new Object[][] {
			{"shraddha", "abc124"},
			{"thakur", "xyz123"}
		};
		
	}
}
