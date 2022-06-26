package com.dataprovider.latest;

import org.testng.annotations.DataProvider;

public class Employee {
	
	private String name;
	private String id;
	
	public Employee(String name, String id) {
		this.name = name;
		this.id = id;
		
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	
	@DataProvider
	public static Employee[] getData2() { // if no name for dataprovider then method name is dataprovider
		return new Employee[] {
				new Employee ("shraddha", "12345"),
				new Employee ("krish", "23466")	
		};
		
	}

}
