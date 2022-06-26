package com.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ExceptionDemo {

	public static void main(String[] args) throws FileNotFoundException, SQLException { // testManager -- top level
																						// logging
		a();

	}

	private static void a() throws SQLException, FileNotFoundException { // test lead // medium level logging
		b();
		c();
	}

	private static void b() { // fresher1 // bottom level logging
		try {
			FileInputStream file = new FileInputStream("");
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}

	}

	private static void c() { // fresher 2
		throw new RuntimeException();
	}

}
