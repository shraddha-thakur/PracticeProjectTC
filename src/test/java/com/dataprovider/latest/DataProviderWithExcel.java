package com.dataprovider.latest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Dataprovider with excel
public class DataProviderWithExcel {
	
	@Test(dataProvider="getData1")
	public void test(Map<String, String> map){
		System.out.println(map.get("username"));
	}
	
	@DataProvider
	public Object [] getData1() throws IOException {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ "/excel/testData.xlsx");
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
	@DataProvider
	public Object [][] getData() throws IOException {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ "/excel/testData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("testing");
		
		int rownum = sheet.getLastRowNum();
		System.out.println(rownum);          
		
		int colnum = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object [rownum][colnum];
	
		for(int i =1; i<=rownum;i++) {
			for(int j=0; j<colnum; j++) {
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue(); // data [1] [0] = abcd .. 
			}
		}
		return data;
	}
	
}

// Object [] [] --> 1st dimension = how many iterations you want to run this test
// 					2nd  dimension = how many parameters you want to feed to your test method

// 2D Object Array is not always the return type of data provider
// Object[][]
// String []
// Employee[]