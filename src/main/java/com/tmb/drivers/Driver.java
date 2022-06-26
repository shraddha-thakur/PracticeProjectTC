package com.tmb.drivers;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.tmb.constants.FrameworkConstants;
import com.tmp.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	private Driver() {

	}

	//	private static WebDriver driver; // class instance

	public static void initDriver() throws Exception {

		//		System.out.println(Thread.currentThread().getId() + " : " + Driver.driver);

		if (Objects.isNull(DriverManager.getDriver())) {
			//		driver==null OR  Objects.isNull(driver)
			//			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());

			// ******************WebDriverManager auto update *drivers.exe**********
			WebDriverManager.chromedriver().setup(); // this LOC updates the drivers

			//			WebDriver driver = new ChromeDriver();
			DriverManager.setDriver(new ChromeDriver()); // refactoring code
			//			DriverManager.getDriver().get(ReadPropertyFile.getValue("url")); // getValue function used

			DriverManager.getDriver().get(ReadPropertyFile.get("url")); // hashmap
			DriverManager.getDriver().manage().window().maximize();

		}
		//		getDriver().manage().deleteAllCookies();
		//		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {

			// driver!=null >> Objects.nonNull(driver)
			//			Logger.log(null, null, "Quitting the browser");
			System.out.println("Quitting the browser");
			DriverManager.getDriver().quit();
			DriverManager.unload();
			//		driver=null;
		}
	}

}
