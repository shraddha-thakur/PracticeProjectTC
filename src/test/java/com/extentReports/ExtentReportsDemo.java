package com.extentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo {
	
	@Test
	public void test() throws IOException {
		// setup code
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Shraddha Automation Framework Training");
		spark.config().setReportName("YouTube TMB Training");
	
		
		// create test
		ExtentTest test1 = extent.createTest("first test");
		test1.pass("checking the logs");
		
		ExtentTest test2 = extent.createTest("second test");
		test2.fail("checking the logs in second test");
		
		// tear down
		extent.flush();
		Desktop.getDesktop().browse(new File("index.html").toURI()); // open the file in desktop default browser
	}
	
}
