package com.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tmb.constants.FrameworkConstants;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginPageTestBasic {

	private LoginPageTestBasic() {

	}

	WebDriver driver;
	@BeforeMethod
	public void setUp() {

		//		System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromeDriverPath() );
		//		driver = new ChromeDriver();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://google.com");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void Test1() {

		driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);

	}

	@Test
	public void Test2() {
		driver.findElement(By.name("q")).sendKeys("Automation Testing", Keys.ENTER);

	}


}


//1. Never Hardcode
//keep right thing at right place

//Naming conventions
//Class or Interface Name >> ShraddhaThakur
//final constant values >> SHRADDHATHAKUR or SHRADDHA_THAKUR
//method name >> shraddhaThakur
//package >> shraddhathakur
