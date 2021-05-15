package com.testing.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtilities {
	public static String getLocator(String locatorName) {
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
		try {
			FileInputStream fis = new FileInputStream(dir + "/src/test/resources/ObjectRepository.properties");
			Properties prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("File not Found");
			e.printStackTrace();
		}
		return dir;
		
	}

	public static void main(String[] args) {
		String value = getLocator("xyz");
	}
}
