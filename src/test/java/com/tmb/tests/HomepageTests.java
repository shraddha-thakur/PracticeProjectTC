package com.tmb.tests;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.drivers.DriverManager;

public final class HomepageTests extends BaseTest {

	private HomepageTests() {

	}

	/*
	 * validate whether title is containg Google Search or google search' validate
	 * whether title is not null and the length of the title is grether than 15 and
	 * less than 100 check the links of the pages >> Testing mini bytes - YouTube
	 * no. of links displayed is exactly 10 or 15
	 * 
	 */
	@Test
	public void Test2() {
		// Driver.initDriver(); // it open another instance of chrome window >>> to
		// avoid this changes done in driver class
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing - YouTube", Keys.ENTER);

		String title = DriverManager.getDriver().getTitle();

		Assert.assertTrue(Objects.nonNull(title), "Title is null");
		Assert.assertTrue(title.length() > 15);
		Assert.assertTrue(title.length() < 100);

		Assert.assertTrue(title.toLowerCase().contains("google search"));
		Assert.assertTrue(title.toLowerCase().matches("\\w.*" + "google search")); // w -> [a-zA-Z0-9] . -> all chars *
		// -> unspecified chars

		// List<WebElement> elements =
		// DriverManager.getDriver().findElements(By.xpath("//h3[.='Testing Mini Bytes -
		// YouTube']")); // not able to find xpath of link of google

		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//div[1]/a/h3"));

		Assert.assertEquals(elements.size(), 8);
		boolean isElementPresent = false;
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase("Testing - YouTube")) {
				isElementPresent = true;
				break;
			}
		}
		Assert.assertTrue(isElementPresent, "Text not found");

	}

	//
	//	@Test
	//	public void verifyPagetitle() {
	//		String title = Driver.driver.getTitle();
	//		System.out.println("Page title is : " + title);
	//		Assert.assertEquals(title, "Google");
	//	}

}
