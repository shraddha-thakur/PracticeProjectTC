package com.trywithresources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) {
		readExcelData();
	}

	private static void readExcelData() {

		// This is try with resources
		// if your class implements Autocloseable
		// advantages of try with resources is you dont have to write finally block
		try (FileInputStream fip = new FileInputStream("")) {

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}
}
