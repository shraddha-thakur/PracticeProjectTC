package com.tmb.constants;

import java.io.File;

public final class FrameworkConstants {
	
	private FrameworkConstants(){
		
	}

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources/";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "executables" + File.separator + "chromedriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "config/config.properties";

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
		
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}


}
