package com.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IRecommendNoPageFactoryDemo {


	private By searchbox = By.name("q");

	private WebDriver driver;

	public IRecommendNoPageFactoryDemo(WebDriver driver) {
		this.driver = driver;
	}

	public void findElements10Times() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			WebElement element = driver.findElement(searchbox);
			element.clear();
			element.sendKeys("Automation Testing");
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
