package com.atom.healthcare.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.TD_LoginWebElement.TD_LoginPageWebElement;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import org.apache.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePageTestNG {
	public static WebDriver driver;
	ATUTestRecorder recorder;

	@BeforeSuite(alwaysRun = true)
	public void startBrowser() throws Exception {
		PrintWriter writer = new PrintWriter("application.log");
		writer.write("");
		writer.close();
		log(TestConfig.dumpTestConfigInfo(), Level.INFO);
		LogManager.getLogger("com.atom.healthcare.Utils").setLevel(Log4jUtil.getLogLevel());
		BasePageObject.log("Browser: " + AtomHC.browser);
		BasePageObject.log("Version: " + AtomHC.version);
		if (AtomHC.browserStackPermission.toLowerCase().trim().equals("Yes".toLowerCase().trim())) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "11");
			caps.setCapability("browser_version", AtomHC.version);
			caps.setCapability("name", "AlphaMD test");
			caps.setCapability("browser", AtomHC.browser);
			String URL = ("https://" + AtomHC.brUserName + ":" + AtomHC.brPassword
					+ "@hub-cloud.browserstack.com/wd/hub");
			BrowserUtil.getBrowserStackBrowser(AtomHC.browser);
			driver = new RemoteWebDriver(new URL(URL), caps);
		} else {
			driver = BrowserUtil.getBrowser(AtomHC.browser);
			driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
			if (TestConfig.isClearBrowserCache()) {
				BrowserUtil.clearBrowserCache(driver, AtomHC.browser);
			}
		}
		enterUrl();
	}
	
	@BeforeClass(alwaysRun = true)
	public void startReporting() throws Exception {
		String testClassName = this.getClass().getName();
		String[] getClass =testClassName.split("Test.");
		String className=getClass[1];
		ExtentReport.startTest(className);
		// startRecorder(method.getName());
	}

	@BeforeMethod(alwaysRun = true)
	public void methodName(Method method) throws Exception {
			logTestEnvironmentInfo(method, AtomHC.browser);

	}

	@AfterMethod(alwaysRun = true)
	public void postTestCase(ITestResult result) throws ClassNotFoundException, IOException, ATUTestRecorderException {
		String testMethodName = result.getMethod().getMethodName();
		String testSuiteName = result.getTestContext().getSuite().getName();
		String testClassName = result.getTestClass().getRealClass().getSimpleName();
		if (AtomHC.browserStackPermission.toLowerCase().trim().equals("Yes".toLowerCase().trim())) {
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
			if (result.getStatus() ==1){
				jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \""+testMethodName+"\"}}");
			}else {
				jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"\""+testMethodName+"\"}}");
			}
			log("TEST RESULT:");
			log(new Date() + " environment="+ AtomHC.envName + " suite=" + testSuiteName + " class="
					+ testClassName + " test=" + testMethodName + " result=" + result.getStatus() + " details="
					+ result.getThrowable());
		}else {
		ExtentReport.extentReports(result);
		if (result.getStatus() == 1) {
			log("TEST RESULT:");
			log(new Date() + " environment=" + AtomHC.envName + " suite=" + testSuiteName + " class="
					+ testClassName + " test=" + testMethodName + " result= PASSED" + " details="
					+ result.getThrowable());
		} else {
			log("TEST RESULT:");
			log(new Date() + " environment=" + AtomHC.envName + " suite=" + testSuiteName + " class="
					+ testClassName + " test=" + testMethodName + " result= FAILED" + " details="
					+ result.getThrowable());
		}
		}
		// stopRecorder();
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() throws Exception {
		ExtentReport.endTest();
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() throws Exception {
		//ExtentReport.endTest();
			try {
				driver.quit();
			} catch (Exception e) {
				//driver.quit();
				log("ERROR: Unable to close browser(s), no browser is currently open.");
			}
	}

	protected void log(String message) { // default is info level
		Log4jUtil.log(message);
	}

	protected void log(String message, String level) {
		Log4jUtil.log(message, level);
	}
	
	protected void log(String message, String level,Throwable object) {
		Log4jUtil.log(message, level,object);
	}

	protected void log(String message, Level level) {
		Log4jUtil.log(message, level);
	}

	private void logTestEnvironmentInfo(Method method, String browser) {
		logTestEnvironmentInfo(method.getName(), TestConfig.getEnvironmentType(), browser);
	}

	private void logTestEnvironmentInfo(String method, EnvironmentTypeUtil.EnvironmentType environment,
			String browser) {
		log("Test case: " + method);
	}

	public static String getScreenshot(String methodName) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String path = System.getProperty("user.dir") + "/test-output/Report/test" + "/" + methodName + " " + timeStamp
				+ ".png";
		FileUtils.copyFile(scrfile, new File(path));
		return path;
	}

	public void startRecorder(String method) throws Exception {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		recorder = new ATUTestRecorder(
				System.getProperty("user.dir") + "/test-output/Report/VideoRecording/" + AtomHC.browser + "/",
				method + " " + timeStamp, false);
		recorder.start();
	}

	public void stopRecorder() throws ATUTestRecorderException {
		recorder.stop();
	}

	public static void deleteVideos(String path) {
		File directory = new File(path);
		File[] files = directory.listFiles();
		for (File file : files) {
			file.delete();
		}

	}
	
	public static void enterUrl() throws Exception {
		TD_LoginPageWebElement	loginPage = new TD_LoginPageWebElement(driver, AtomHC.URL);
		driver.navigate().refresh();
	}
	
	public String getClassName() {
		String className = this.getClass().getSimpleName();
		return className;
	}

}
