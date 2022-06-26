package com.annotations;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class AnnotationsTest {

	@Test(description = "checking whether the parameter is accessible via reflection at runtime")
	public void test(Method m) {
		System.out.println(m.getAnnotation(Test.class).description());
	}

}
