package com.threadlocal;

public class ThreadLocalSubClassDemo extends ThreadLocal<String>{

	@Override
	protected String initialValue() {
		// TODO Auto-generated method stub
		return "abcd";
		
	}
	
	public static ThreadLocal<String> myThreadLocal = new ThreadLocal<String>() {
		
		@Override
		protected String initialValue() {
			// TODO Auto-generated method stub
			return "abcdef";
		}
		
	};
	
	
}
