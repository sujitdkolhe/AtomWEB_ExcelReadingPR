package com.atom.healthcare.util;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atom.healthcare.Pojo.AtomHC;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserStackBaseTest {
	public static WebDriver driver;

	@BeforeMethod
	@Parameters({ "os", "os_version", "browser_version", "browser" })
	public void beforeMethod(String os, String os_version, String browser_version, String browser) throws Exception {
		AtomHC.propData = new PropertyFileLoader();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", os);
		caps.setCapability("os_version", os_version);
		caps.setCapability("browser_version", browser_version);
		caps.setCapability("name", "My first test");
		caps.setCapability("browser", browser);
		String URL = ("https://" + AtomHC.propData.getProperty("browser.stack.username") + ":"
				+ AtomHC.propData.getProperty("browser.stack.password") + "@hub-cloud.browserstack.com/wd/hub");
		if (browser.equals("chrome")) {
			getBrowser(browser);
		}

		driver = new RemoteWebDriver(new URL(URL), caps);
		LogManager.getLogger("com.atom.healthcare.Utils").setLevel(Log4jUtil.getLogLevel());
	}

	protected void log(String message) { // default is info level
		Log4jUtil.log(message);
	}

	protected void log(String message, String level) {
		Log4jUtil.log(message, level);
	}

	protected void log(String message, Level level) {
		Log4jUtil.log(message, level);
	}

	@AfterMethod(alwaysRun = true)
	public void postTestCase(ITestResult result) throws ClassNotFoundException, IOException, ATUTestRecorderException {
		String testMethodName = result.getMethod().getMethodName();
		String testSuiteName = result.getTestContext().getSuite().getName();
		String testClassName = result.getTestClass().getRealClass().getSimpleName();
//		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		if (result.getStatus() ==1){
			//jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \""+testMethodName+"\"}}");
		}else {
			//jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"\""+testMethodName+"\"}}");
		}
		try {
			driver.quit();
		} catch (Exception e) {
			log("ERROR: Unable to close browser(s), no browser is currently open.");
		}

		log("TEST RESULT:");
		log(new Date() + " environment=" + TestConfig.getEnvironmentType() + " suite=" + testSuiteName + " class="
				+ testClassName + " test=" + testMethodName + " result=" + result.getStatus() + " details="
				+ result.getThrowable());
		// stopRecorder();
	}

	public static void getBrowser(String bname) {
		switch (bname) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
		case "safari":
			// driver= new SafariDriver();
			break;
		default:
			System.err.println("Invalid browser name : " + bname);
		}

	}
}
