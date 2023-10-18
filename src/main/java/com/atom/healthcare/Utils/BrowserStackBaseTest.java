package com.atom.healthcare.Utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.page.Pojo.AHC;
import com.atom.healthcare.util.EnvironmentTypeUtil;
import com.atom.healthcare.util.Log4jUtil;
import com.atom.healthcare.util.TestConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserStackBaseTest {
	protected  AppiumDriver driver;
	public static Properties properties = new Properties();
	//JavascriptExecutor jse = (JavascriptExecutor)driver;

	
	@BeforeSuite()
	public void beforeSuite() throws IOException, InterruptedException {
		Thread.sleep(3000);
		PrintWriter writer = new PrintWriter("application.log");
		writer.write("");
		writer.close();
	}

	@BeforeMethod
	@Parameters({ "device", "os_version", "project", "build", "name", "app" })
	public void setCapabilities(String device, String os_version, String project, String build, String name, String app,Method method) throws Exception {
		PropertyFileLoader propertyData = new PropertyFileLoader();
		AHC.platformName=device;
		if (AHC.platformName.equals("Google Pixel 3")) {
			// Android
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("device", device);
				caps.setCapability("os_version", os_version);
				caps.setCapability("project", project);
				caps.setCapability("build", build);
				//caps.setCapability("name", name);
				caps.setCapability("app", app);
				 
				driver = new AndroidDriver<AndroidElement>(new URL("https://"
						+ propertyData.getProperty("browser.stack.username") + ":"
						+ propertyData.getProperty("browser.stack.password") + "@hub-cloud.browserstack.com/wd/hub"), caps);
		} else if (device.equals("iPhone 11 Pro")) {
			// Ios
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("device", device);
			caps.setCapability("os_version", os_version);
			caps.setCapability("project", project);
			caps.setCapability("build", build);
			//caps.setCapability("name", name);
			caps.setCapability("app", app);
			driver = new IOSDriver<IOSElement>(new URL("https://" + propertyData.getProperty("browser.stack.username")
					+ ":" + propertyData.getProperty("browser.stack.password") + "@hub-cloud.browserstack.com/wd/hub"),
					caps);
		}
		String methodName = method.getName();
		log("Method Name: " + methodName);
		logTestEnvironmentInfo(method);
	}
	
	@AfterMethod
	public void postTest(ITestResult result) throws Exception {
		//ExtentReport.extentReports(result);
		postTestCase(result);
		driver.closeApp();
	}
	
	@AfterClass
	public void afterClass() {
		//ExtentReport.endTest();
		if (AHC.platformName.equals("Google Pixel 3")) {
			driver.quit();
		} else {
			driver.quit();
		}
	}
	

	//@AfterMethod(alwaysRun = true)
	public void postTestCase(ITestResult result) throws ClassNotFoundException, IOException {
		String testMethodName = result.getMethod().getMethodName();
		String testSuiteName = result.getTestContext().getSuite().getName();
		String testClassName = result.getTestClass().getRealClass().getSimpleName();
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		 // driver = new RemoteWebDriver(new URL(URL));
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		if (result.getStatus() ==1){
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \""+testMethodName+"\"}}");
		}else {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+testMethodName+"\"}}");
		}
		try {
			
			//driver.quit();
		} catch (Exception e) {
			log("ERROR: Unable to close app(s), no app is currently open.");
		}

		log("TEST RESULT:");
		log(new Date() + " environment=" + TestConfig.getEnvironmentType() + " suite=" + testSuiteName + " class="
				+ testClassName + " test=" + testMethodName + " result=" + result.getStatus() + " details="
				+ result.getThrowable());
		
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
	
	private void logTestEnvironmentInfo(Method method) {
		logTestEnvironmentInfo(method.getName(), TestConfig.getEnvironmentType());
	}

	private void logTestEnvironmentInfo(String method, EnvironmentTypeUtil.EnvironmentType environment) {
		log("Test case: " + method);
		log("Execution Environment: " + environment);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    // Setting name of the test
	    jse.executeScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\""+method+" \" }}");
		//log("Execution Browser: " + browser);
	}
	


}
