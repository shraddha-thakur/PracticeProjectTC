package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryDemoWithCacheLookUp {

	@CacheLookup
	@FindBy(name="q")
	private WebElement searchbox;

	private WebDriver driver;

	public PageFactoryDemoWithCacheLookUp(WebDriver driver) {
		PageFactory.initElements(driver, this);  // verbose
		this.driver = driver;
	}

	public void findElements10Times() {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			searchbox.clear();
			searchbox.sendKeys("Automation Testing");
		}
		System.out.println(System.currentTimeMillis() - startTime);

	}


}
