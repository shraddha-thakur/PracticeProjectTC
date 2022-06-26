package com.tmb.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.tmb.drivers.Driver;

public class BaseTest {

	protected BaseTest() {
		// protected constructor
	}

//	private , protected, default --->>> public  ***order of using access modifiers
	
	@BeforeMethod
	protected void setUp() throws Exception {
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
}
