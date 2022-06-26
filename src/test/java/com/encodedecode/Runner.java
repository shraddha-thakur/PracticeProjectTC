package com.encodedecode;

import java.util.Base64;

public class Runner {

	public static void main(String[] args) {

		String encodedstring = Base64.getEncoder().encodeToString("test".getBytes());
		System.out.println(encodedstring);

		String decodedstring = new String(Base64.getDecoder().decode("dGVzdA==".getBytes()));
		System.out.println(decodedstring);
	}

}
