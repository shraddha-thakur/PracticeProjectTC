package com.dataprovider.latest;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Dataprovider with same name to pass to different test methods
public class DataProviderTest2 {

	@Test(dataProvider="getData1")
	public void test1(Employee emp) {
		System.out.println(emp.getId());
		System.out.println(emp.getName());
	}
	
	@Test(dataProvider="getData1")
	public void test2(String username){
		System.out.println(username);
	}
	
	@DataProvider
	public static Object [] getData1(Method m) { 
		
		if(m.getName().equalsIgnoreCase("test1")) {
	
			return new Employee[] {
				new Employee ("shraddha", "12345"),
				new Employee ("krish", "23466")	
		};	
		}
		else if (m.getName().equalsIgnoreCase("test2")) {
		return new Object [][] {
			{"shraddha"},
			{"thakur"},
			{"automation"}
		};}
		return null;
	}
}

// Object [] [] --> 1st dimension = how many iterations you want to run this test
// 					2nd  dimension = how many parameters you want to feed to your test method

// 2D Object Array is not always the return type of data provider
// Object[][]
// String []
// Employee[]