package com.atom.healthcare.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.page.Pojo.AHC;
import com.atom.healthcare.page.objects.TD_LoginPage.TD_LoginPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.Log4jUtil;
import com.atom.healthcare.util.TestConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import java.awt.*;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class BaseTest {
	public static AppiumDriver driver;
//	public static AndroidDriver androidDriver;
//	public static IOSDriver iOSDriver;
	public static AppiumDriverLocalService service;
	private ScreenRecorder screenRecorder;

	@BeforeSuite(alwaysRun = true)
	public void setCapabilities() throws Exception {
		Thread.sleep(3000);
		PrintWriter writer = new PrintWriter("application.log");
		writer.write("");
		writer.close();
		LogManager.getLogger("com.atom.healthcare.Utils").setLevel(Log4jUtil.getLogLevel());
		BasePageObject.log("Device Name: " + AHC.deviceName);
		BasePageObject.log("Platform Name: " + AHC.platformName);
		BasePageObject.log("Platform version: " + AHC.platformVersion);
		killNode();
		startServer();
		if (AtomHC.browserStackPermission.toLowerCase().trim().equals("Yes".toLowerCase().trim())) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", AHC.platformName);
			caps.setCapability("deviceName", AHC.deviceName);// eg. Samsung Galaxy S22 Ultra
			caps.setCapability("platformVersion", AHC.platformVersion);
			// caps.setCapability("project", "AlphaMD");//optional
			// caps.setCapability("build", "1.0");////optional
			// caps.setCapability("name", "Alphamd Test");//optional
			caps.setCapability("platformVersion", AHC.platformVersion);
			caps.setCapability("app", "bs://9ac8d43a3afe57e019fdf66873bd3f9f876bb4cb");// get value from browser stack
																						// for build value
			caps.setCapability("autoGrantPermissions", "true");
			driver = new AndroidDriver<AndroidElement>(new URL(
					"https://" + AtomHC.brUserName + ":" + AtomHC.brPassword + "@hub-cloud.browserstack.com/wd/hub"),
					caps);
		} else {
			if (AHC.platformName.equals("Android")) {
				driver = androidCapabilities(AtomHC.appName);
			} else {
				driver = iOSCapabilities(AtomHC.appName);
			}
			try {
				// startRecording(method.getName());
				TD_LoginPage loginPage = new TD_LoginPage(driver);
				loginPage.selectPreferedLanguage(AHC.language);
			}catch(Exception e) {
				log("App is already install and on login page");
			}
			

		}
		// Thread.sleep(10000);
		// startRecording(method.getName());
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		if (AtomHC.browserStackPermission.toLowerCase().trim().equals("Yes".toLowerCase().trim())) {
		} else {
			String testClassName = this.getClass().getName();
			String[] getClass = testClassName.split("Test.");
			String className = getClass[1];
			ExtentReport.startTest(className);
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws Exception {
		String methodName = method.getName();
		log("Method Name: " + methodName);
		logTestEnvironmentInfo();
	}

	@AfterMethod(alwaysRun = true)
	public void postTest(ITestResult result) throws Exception {
		if (AtomHC.browserStackPermission.toLowerCase().trim().equals("Yes".toLowerCase().trim())) {
		} else {
			ExtentReport.extentReports(result);
		}
		postTestCase(result);
		// stopRecording();
		// driver.closeApp();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (AtomHC.browserStackPermission.toLowerCase().trim().equals("Yes".toLowerCase().trim())) {
		} else {
			ExtentReport.endTest();
		}

//		if (AHC.platformName.equals("Android")) {
//			driver.quit();
//		} else {
//			driver.quit();
//		}
	}

	@AfterSuite
	public void stopServer() throws ClassNotFoundException {
		try {
			driver.closeApp();
			driver.quit();
			service.stop();
		} catch (Exception e) {
			driver.closeApp();
			driver.quit();
			service.stop();
			log("ERROR: Unable to close App(s), no app is currently open.");
		}

	}

	// @BeforeTest
	public AppiumDriverLocalService startServer() {
		if (AtomHC.browserStackPermission.toLowerCase().trim().equals("Yes".toLowerCase().trim())) {
			log("Execute on browser stack");
		} else {
			if (AHC.platformName.equals("Android")) {
				boolean flag = checkIfServerIsRunnning(4723);
				if (!flag) {
					service = AppiumDriverLocalService.buildDefaultService();
					service.start();
				}
			} else {
				service = new AppiumServiceBuilder()
						.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				//"/Applications/Appium.app/Contents/Resources/node/bin/node");  
				//"/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
			}
			return service;
		}
		return null;
	}

	public void killNode() throws IOException {
		if (AtomHC.browserStackPermission.toLowerCase().trim().equals("Yes".toLowerCase().trim())) {
			log("Execute on browser stack");
		} else if (AHC.platformName.equals("Android")) {
			Runtime.getRuntime().exec("cmd /c taskkill /F /IM node.exe");
		} else {
			log("iOS test");
			String[] command ={"/usr/bin/killall","-KILL","node"};  
			Runtime.getRuntime().exec(command); 
		}
	}
	

	public AppiumDriver androidCapabilities(String appName) throws IOException, InterruptedException {
		File appDir = new File("./src/test/resources/appTest/");// application path
		File app = new File(appDir, appName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// startEmulator();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, AHC.deviceName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, AHC.platformName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, AHC.platformVersion);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		capabilities.setCapability("autoGrantPermissions", "true");
		// String ipAddress = Inet4Address.getLocalHost().getHostAddress();
		try {// if app is already install then this try block is executed and app not install
				// then catch block will be executed
			capabilities.setCapability("appPackage", "com.alphamd.health");
			capabilities.setCapability("appActivity", "crc6461b666c94789a8d4.MainActivity");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");//is used when we don't want to reset app
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			if (driver.isAppInstalled("com.alphamd.health")) {
				
				log("App is already installed");
			} else {
				log("App is not already installed");
			}
		} catch (Exception e) {
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");//is used when we don't want to reset app
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		// driver = androidDriver;
		return driver;
	}

	public AppiumDriver iOSCapabilities(String appName) throws IOException, InterruptedException {
		// Setting Desired Capabilities
		File appDir = new File("./src/test/resources/appTest/");// application path
		File app = new File(appDir, appName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", AHC.deviceName);
		capabilities.setCapability("platformVersion", AHC.platformVersion);
		capabilities.setCapability("platformName", AHC.platformName);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		capabilities.setCapability("xcodeOrgId", "sujit.kolhe@alphamd.com");
		capabilities.setCapability("xcodeSigningId", "iPhone Developer");
		capabilities.setCapability("udid", AHC.udid);
		capabilities.setCapability("autoGrantPermissions", "true");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilities.setCapability("autoAcceptAlerts", "true");
		try {
		capabilities.setCapability("bundleId", "com.alphamd.health");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		if (driver.isAppInstalled("com.alphamd.health")) {
			
			log("App is already installed");
		} else {
			log("App is not already installed");
		}
	} catch (Exception e) {
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");//is used when we don't want to reset app
		//capabilities.setCapability("autoGrantPermissions", "true");
		//capabilities.setCapability(MobileCapabilityType.APP, "/Users/sujitkolhe/Desktop/alph/UIKitCatalog.app");
		// capabilities.setCapability("mobile:launchApp", "com.apple.mobileslideshow");
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		// driver = iOSDriver;
		return driver;
	}

	public static String getScreenshot(String methodName) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String path = System.getProperty("user.dir") + "\\test-output\\Report\\test" + "\\" + methodName + " "
				+ timeStamp + ".png";
		FileUtils.copyFile(scrfile, new File(path));
		return path;
	}

	public static void startEmulator() throws IOException, InterruptedException {
		String emulatorBatFile = AHC.batFilePath;
		Runtime.getRuntime().exec("cmd /c " + System.getProperty("user.dir") + emulatorBatFile);
		Thread.sleep(10000);
	}

	public static boolean checkIfServerIsRunnning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	protected void log(String message) {
		Log4jUtil.log(message);
	}

	protected void log(String message, Level level) {
		Log4jUtil.log(message, level);
	}

	protected void logTestEnvironmentInfo() throws IOException {
		logTestEnvironmentInfo(AtomHC.appName);
	}

	public void logTestEnvironmentInfo(String appname) {
		if (AtomHC.browserStackPermission.toLowerCase().trim().equals("Yes".toLowerCase().trim())) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// Setting name of the test
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\""
					+ "method" + " \" }}");
		} else {
			log("Execution Environment: " + AtomHC.envName);
			log("Device Name: " + AHC.deviceName);
			log("Application Name: " + AtomHC.appName);
		}
	}

	public void postTestCase(ITestResult result) throws ClassNotFoundException {
		String testMethodName = result.getMethod().getMethodName();
		String testSuiteName = result.getTestContext().getSuite().getName();
		String testClassName = result.getTestClass().getRealClass().getSimpleName();
		if (AtomHC.browserStackPermission.toLowerCase().trim().equals("Yes".toLowerCase().trim())) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			if (result.getStatus() == 1) {
				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \""
								+ testMethodName + "\"}}");
			} else {
				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""
								+ testMethodName + "\"}}");
			}
//			try {
//				driver.quit();
//			} catch (Exception e) {
//				log("ERROR: Unable to close app(s), no app is currently open.");
//			}

			log("TEST RESULT:");
			log(new Date() + " environment=" + TestConfig.getEnvironmentType() + " suite=" + testSuiteName + " class="
					+ testClassName + " test=" + testMethodName + " result=" + result.getStatus() + " details="
					+ result.getThrowable());
		} else {
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
	}

	public static void deleteVideos(String path) {
		File directory = new File(path);
		File[] files = directory.listFiles();
		for (File file : files) {
			file.delete();
		}
	}

	public void startRecording(String method) throws Exception {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File file = new File(
				System.getProperty("user.dir") + "\\test-output\\Report\\VideoRecording\\" + AHC.deviceName);
		int width = 270;
		int height = 580;
		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// int width = screenSize.width;
		// int height = screenSize.height;
		Rectangle captureSize = new Rectangle(0, 0, width, height);
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
				new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
				null, file, method + " " + timeStamp);
		this.screenRecorder.start();
	}

	public void stopRecording() throws Exception {
		this.screenRecorder.stop();
	};

	public static void openBrowserAppInMobile() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if (AHC.platformName.equals("Android")) {
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "default");
			capabilities.setCapability("deviceName", "My Phone");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("noReset", true);
			// Instantiate Appium Driver
			AHC.appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			AHC.appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "default");
			capabilities.setCapability("xcodeOrgId", "sujit.kolhe@alphamd.com");
			capabilities.setCapability("xcodeSigningId", "iPhone Developer");
			capabilities.setCapability("udid", "c3556d55079e99ca2b03e2f48f85da2e75d54546");
			capabilities.setCapability("bundleId", "com.example.apple-samplecodealph.UICatalog");
			capabilities.setCapability("noReset", true);
			AHC.appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			AHC.appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// capabilities.setCapability(MobileCapabilityType.APP,
			// "/Users/sujitkolhe/Desktop/UIKitCatalog.app");
			//capabilities.setCapability(MobileCapabilityType.APP, "/Users/sujitkolhe/Desktop/alph/UIKitCatalog.app");
			
			// capabilities.setCapability("bundleId", "com.apple.mobileslideshow");
			// capabilities.setCapability("mobile:launchApp", "com.apple.mobileslideshow");
			// capabilities.setCapability(MobileCapabilityType.APP,
			// "/Users/sujitkolhe/Desktop/alph/UIKitCatalog.app");
			//AHC.appiumDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}
	}

	public static void getUrl(String url) {
		AHC.appiumDriver.get(url);
	}

	public static void stopEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c " + "adb emu kill");
	}

	public String getClassName() {
		String className = this.getClass().getSimpleName();
		return className;
	}
}
