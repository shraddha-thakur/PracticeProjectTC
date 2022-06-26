package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

//	whenever test is failed this method retry will be enabled. If this method return true, then failed method will be rerun
	
	
	int counter = 0;
	int limit = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(counter<limit) {
			counter++;
			return true;
		}
		return false;
	}

	// there are 2 ways add this listener 
	// 1. at test level
	
//	@Test(retryAnalyzer = RetryAnalyzer.class)
//	public void test2() {System.out.println("test2");}
	
	// 2. at annotation listeners
//	annotation.setRetryAnalyzer(RetryAnalyzer.class);
	
}
