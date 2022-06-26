package com.Enums;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class EnumRunner {

	public static void main(String []args) {

		// Java compiler by default  a add toString 
		//		System.out.println(Severity.CRITICAL);

		// To Print Enums 
		Severity[] a  = Severity.values();
		for(Severity sev : a) {
			System.out.println(sev);
		}

		Arrays.asList(Severity.values()).forEach(e->System.out.println(e));
		Arrays.asList(Severity.values()).forEach(System.out :: println);

		EnumSet<Severity> enumset = EnumSet.of(Severity.CRITICAL, Severity.HIGH);
		enumset.forEach(System.out::println);

		// this is imp for sel framework
		Map<Severity, String> map = new EnumMap<>(Severity.class);
		map.put(Severity.HIGH, "high");
		map.put(Severity.MEDIUM, "med");
		map.put(Severity.LOW, "low");

		map.forEach((k,v)->System.out.println(k));


		//		System.out.println(Severity.CRITICAL.asLowerCase()); // added in Severiry class 
		//	
		System.out.println(Severity.CRITICAL.getFixingHours());



		//		Severity sev =  Severity.CRITICAL;
		//		
		//		Severity a = Severity.valueOf("CRITICAL");
		//
		//		if (a == Severity.CRITICAL) {
		//			System.out.println("critical");
		//		} else if  (sev == Severity.MEDIUM) {
		//			System.out.println("medium");
		//		}


		//		switch (sev) {
		//		case CRITICAL:
		//			System.out.println("critical");
		//			break;
		//		case MEDIUM:
		//			System.out.println("medium");
		//			break;
		//		}




	}

}

