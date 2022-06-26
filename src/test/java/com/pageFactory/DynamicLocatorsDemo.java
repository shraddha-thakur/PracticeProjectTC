package com.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLocatorsDemo {

	private WebDriver driver;
	
	public DynamicLocatorsDemo(WebDriver driver) {
		
	}
	
	// //div[normalize-space()='Amazon Prime Music']
	
	//div[text()='Amazon Prime Music']//parent::a

	private String menuItem = "//div[text()='%value%']//parent::a";
	
	public void clickMenu(String value) {
		driver.findElement(By.xpath(menuItem.replace("%value%", value)));
		
	}
	
	// this is possible without using Pagefactory so that we can use dynamic locators 

}
