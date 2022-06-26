package com.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.drivers.Driver;
import com.tmb.drivers.DriverManager;

public final class LoginPageTest extends BaseTest { // final keyword is used for class which would not extend by any
													// other class

	private LoginPageTest() {
		// create private constructor so that no one would create object of this class
	}

	@Test
	public void Test1() {

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);

	}

//	@Test	
//	public void Test2() {
//		driver.findElement(By.name("q")).sendKeys("Automation Testing", Keys.ENTER);
//
//	}

}

//1. Never Hardcode
//keep right thing at right place

//Naming conventions 	
//Class or Interface Name >> ShraddhaThakur
//final constant values >> SHRADDHATHAKUR or SHRADDHA_THAKUR 
//method name >> shraddhaThakur
//package >> shraddhathakur
