package com.dataprovider.latest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider="getData2", dataProviderClass=Employee.class)
	public void test1(Employee emp) {
//		String a[] = {"shraddha", "thakur", "automation"};
//		for(int i = 0; i<= a.length ; i++) {
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println("enter username");// assume these are no. of testcases
		System.out.println("enter password"); // one of its failed but we dont know the result of next TC
		System.out.println("click login"); // we need to remove failed and rerun tc again
//		Assert.assertTrue(false); // 			to avoid this we use dataprovider
//		}
	}
	@DataProvider
	public String[] getData() { // if no name for dataprovider then method name is dataprovider
		String a[] = {"shraddha", "thakur", "automation"};	
		return a;
	}
	
	@DataProvider
	public Object [][] getData1() { // if no name for dataprovider then method name is dataprovider
		return new Object [][] {
			{"shraddha"},
			{"thakur"},
			{"automation"}
		};
	}


	

}

// Object [] [] --> 1st dimension = how many iterations you want to run this test
// 					2nd  dimension = how many parameters you want to feed to your test method

// 2D Object Array is not always the return type of data provider
// Object[][]
// String []
// Employee[]