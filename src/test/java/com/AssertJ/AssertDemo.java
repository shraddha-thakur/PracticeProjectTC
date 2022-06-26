package com.AssertJ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertDemo {

	@Test
	public void stringTest() {

		String temp = "Hello World";
		String a = "";
		String b = "   ";

		Assertions.assertThat(temp)
		.isNotNull()
		.as("String is actually empty").isNotEmpty()
		.as("String is actually blank").isNotBlank()
		.isEqualTo("Hello World")
		.contains("Hello")
		.doesNotContain("Hi")
		.containsWhitespaces()
		.containsIgnoringCase("world")
		.matches("\\w.*" + " World")
		.doesNotContainPattern("\\d.*") // 0-9 -> does not contain digits
		.hasSize(11).hasSizeGreaterThan(10).hasSizeLessThan(20).hasSizeBetween(10, 20).endsWith("World")
		.isInstanceOf(String.class);

	}

	@Test
	public void numbersTest() {

		int a = 10;

		Assertions.assertThat(a)
		.isBetween(3, 15)
		.isEqualTo(10)
		.isCloseTo(14, Offset.offset(5)) // 10 +- 5 >> 5-15
		.isCloseTo(12, Percentage.withPercentage(30)) // 7 - 13
		.isNotCloseTo(15, Percentage.withPercentage(30))
		.isPositive()
		.isEven()
		.isGreaterThanOrEqualTo(5)
		.isLessThanOrEqualTo(20);

	}

	//	@Test
	public void listTest() {
		List<String> list1 = Arrays.asList("Shraddha", "Sham", "Thakur");
		List<String> list2 = Arrays.asList("Shraddha", "Sham");
		List<String> list3 = Arrays.asList("Automation", "Selenium");

		Assertions.assertThat(list1)
		.hasSize(3)
		.hasSizeBetween(1, 5)
		.hasAtLeastOneElementOfType(String.class)
		.isNotEmpty().contains("Shraddha")
		.doesNotContain("Automation")
		.startsWith("Shraddha")
		.containsExactlyInAnyOrder("Sham", "Thakur", "Shraddha")
		.containsExactly("Shraddha", "Sham", "Thakur")
		.withFailMessage(()->"String is not having size less than 3").allMatch(s -> s.length()<3)
		.containsAll(list2).doesNotContainAnyElementsOf(list3);

	}


	//	@Test
	public void mapTest() {
		Map<String,String> map = new HashMap<>();

		map.put("name", "Shraddha");
		map.put("channel", "Automation");
		map.put("game", "ludo");

		Assertions.assertThat(map)
		.containsEntry("name", "Shraddha")
		.hasSize(3)
		.isNotEmpty()
		.doesNotContainEntry("fav", "football")
		.doesNotContainKey("Game")
		.containsKey("channel")
		.containsValue("Automation");

	}


	@Test
	public void customClassTest() {

		Employee emp1 = new Employee(25, "Shraddha", 100); // o1
		Employee emp2 = new Employee(25, "Shraddha", 100); // o2

		Assert.assertEquals(emp1, emp2);

		Assertions.assertThat(emp1)
		.isEqualToComparingFieldByField(emp2)
		.isNotNull()
		.isInstanceOf(Employee.class)
		.hasFieldOrProperty("age")
		.hasFieldOrPropertyWithValue("name", "Shraddha")
		.extracting(e -> e.age).isNotEqualTo(24);

	}

}
