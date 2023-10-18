package com.atom.healthcare.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.atom.healthcare.Utils.EnvironmentTypeUtil.EnvironmentType;

import io.appium.java_client.AppiumDriver;


/**
 * Description : AHC Util will contain the methods for utilities those are
 * specific to AHC Util.
 * 
 */
public class TestConfig extends BasePageObject {

	public TestConfig(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static Properties properties = new Properties();
	private static final String DEFAULT_PROP_FILENAME = "testConfig.properties";
	
	private static String testRoot, testResultScreenshots, testConfigFile;
	static {

		try {
			testRoot = System.getProperty("testRoot");
			if (testRoot == null)
				testRoot = System.getProperty("user.dir"); // setting default testRoot

			FileInputStream in = null;
			if (testConfigFile == null) {
				in = new FileInputStream(testRoot + File.separator + DEFAULT_PROP_FILENAME);
			} else {
				in = new FileInputStream(testRoot + File.separator + testConfigFile);
			}
			properties.load(in);
			in.close();

		} catch (IOException e) {
			System.err.println("Failed to read: " + testConfigFile);
		}
	}

	/**
	 * Desc:- Method will get the value of "test.environment" from
	 * testConfig.properties
	 */
	public static EnvironmentType getEnvironmentType() {
		String env = getUserDefinedProperty("test.environment");
		if (env != null) {
			return EnvironmentTypeUtil.getEnvironmentType(env);
		} else {
			return EnvironmentTypeUtil
					.getEnvironmentType(String.valueOf(properties.getProperty("test.environment")).trim());
		}
	}
	
	/**
	 * Desc:- Method will get the value of "emulator.bat.file.path" from
	 * testConfig.properties
	 */

	public static String getEmulatorBatFile() {
		String env = getUserDefinedProperty("emulator.bat.file.path");
		System.out.println("test.device  " + env);
		if (env != null) {
			return env;
		} else {
			return properties.getProperty("emulator.bat.file.path").trim();
		}
	}
	
	public static String getEmulatorBatFile1() {
		String env = getUserDefinedProperty("emulator.bat.file.path1");
		System.out.println("test.device  " + env);
		if (env != null) {
			return env;
		} else {
			return properties.getProperty("emulator.bat.file.path1").trim();
		}
	}

	public static void printCookies(WebDriver driver) {
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Printing Cookies -------");
		for (Cookie c : cookies) {
			System.out.println(c.toString());
		}
		System.out.println("--------------------------");
	}

	/**
	 * Optional parameter in testConfig.properties default value is false
	 */
	public static boolean isClearBrowserCache() {
		String clearBrowserCache = String.valueOf(properties.getProperty("clear.browser.cache")).trim();
		return clearBrowserCache.equalsIgnoreCase("true") ? true : false;
	}
	
	public static String getTestEnv() {
		String env_testenv = System.getProperty("test.environment");
		String prop_testenv = String.valueOf(properties.getProperty("test.environment"));
		if (env_testenv != null)
			return env_testenv.trim();
		else if (!prop_testenv.equals("null"))
			return prop_testenv.trim();
		else
			return null;
	}
	
	public static String getRetryAttempts() {
		String env_retry = System.getProperty("retry.attempts");
		String prop_retry = String.valueOf(properties.getProperty("retry.attempts"));
		if (env_retry != null)
			return env_retry.trim();
		else if (!prop_retry.equals("null"))
			return prop_retry.trim();
		else
			return null;
	}
	
	public static String getUserDefinedProperty(String propertyName) {
		String env_propertyName = System.getProperty(propertyName);
		if (env_propertyName == null) {
			String prop_propertyName = String.valueOf(properties.getProperty(propertyName));
			if (prop_propertyName == null)
				return null;
			else
				return prop_propertyName;
		} else {
			return env_propertyName;
		}
	}
	
	public static String getLoggerLevel() {
		String env_level = System.getProperty("logger.level");
		String prop_level = String.valueOf(properties.getProperty("logger.level"));
		if (env_level != null)
			return env_level.trim();
		else if (prop_level != null)
			return prop_level.trim();
		else
			return null;
	}
	
	public static boolean isCaptureScreenshot() {
		String env_captureScreenshot = System.getProperty("capture.screenshot");
		String prop_captureScreenshot = String.valueOf(properties.getProperty("capture.screenshot"));
		if (env_captureScreenshot != null)
			return (env_captureScreenshot.trim().equalsIgnoreCase("true")) ? true : false;
		else if (prop_captureScreenshot != null)
			return (prop_captureScreenshot.trim().equalsIgnoreCase("true")) ? true : false;
		else
			return false;
	}

	public static String getTestResultScreenshot() {
		return testResultScreenshots;
	}
	
	/**
	 * Print name of calling method. NOTE: This only works if you call the method
	 * directly from a another method with no other method in between. The index of
	 * [2] represents the position of the calling method in the trace In this case,
	 * that would be the method that directly calls this method.
	 */
	public static void PrintMethodName() {
		System.out.println("###>>> --- METHOD: " + Thread.currentThread().getStackTrace()[2].getClassName() + "."
				+ Thread.currentThread().getStackTrace()[2].getMethodName());
	}
	
}
