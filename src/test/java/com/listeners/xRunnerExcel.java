package com.listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class xRunnerExcel {

	@BeforeSuite
	public void setUpSuite() { System.out.println("before suite in runner");	}
	
	@AfterSuite
	public void tearDownSuite() { System.out.println("after suite in runner");	}
	
	@BeforeMethod
	public void setUp() { System.out.println("before method in runner");	}
	
	@AfterMethod
	public void tearDown() { System.out.println("after method in runner");	}
	
	@Test(dataProvider="getData1")
	public void test1(Map<String, String> map) {System.out.println("test1");}
	
	@Test
	public void test2() {System.out.println("test2");
	Assert.assertTrue(false);
	}
	
	@Test
	public void test3() {System.out.println("test3");}
	
	@DataProvider
	public Object [] getData1() throws IOException {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ "/excel/testDataWithExcel.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("testing");
		
		int rownum = sheet.getLastRowNum();
		int colnum = sheet.getRow(0).getLastCellNum();

		Object[] data = new Object [rownum];
		Map<String, String> map; 
	
		
		for(int i =1; i<=rownum;i++) {
			map = new HashMap<>();  
			
			for(int j=0; j<colnum; j++) {
				
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				data[i-1] = map;
			}
		}
		return data;
	}

	
}
