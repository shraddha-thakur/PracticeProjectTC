package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Runner {

	WebDriver driver;

	@BeforeMethod 
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("Browser quit");
	}
	@Test
	public void test() { // 5101, 4782, 4340
		driver.get("https://www.google.com");
		PageFactoryDemo pfd = new PageFactoryDemo(driver);
		pfd.findElements10Times();
	}

		@Test
	public void test1() { // 4980, 4038, 3831
		driver.get("https://www.google.com");
		PageFactoryDemoWithCacheLookUp pfd = new PageFactoryDemoWithCacheLookUp(driver);
		pfd.findElements10Times();
	}
	@Test
	public void test2() { // 3711, 4055, 4867, 4743
		driver.get("https://www.google.com");
		IRecommendNoPageFactoryDemo npfd = new IRecommendNoPageFactoryDemo(driver);
		npfd.findElements10Times();
	}
}
